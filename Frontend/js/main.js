/**
 * main.js — Quiroga Law Office
 * Dynamically loads team members, blog articles, and client victories
 * from the Spring Boot REST API and renders them into the page.
 */

const API_BASE = 'http://localhost:8081';

// ─── Utilities ───────────────────────────────────────────────────────────────

/**
 * Returns up to two initials from a full name (e.g. "Héctor Quiroga" → "HQ").
 */
function getInitials(name) {
  return name
    .split(' ')
    .filter(word => word.length > 0)
    .map(word => word[0])
    .join('')
    .substring(0, 2)
    .toUpperCase();
}

/**
 * Formats an ISO date string or LocalDate array into a readable year + month.
 * Spring serialises LocalDate as [year, month, day].
 */
function formatDate(publishedAt) {
  if (Array.isArray(publishedAt)) {
    const [year, month, day] = publishedAt;
    return new Date(year, month - 1, day).toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
    });
  }
  const d = new Date(publishedAt);
  return isNaN(d) ? publishedAt : d.toLocaleDateString('en-US', {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  });
}

// ─── Articles ─────────────────────────────────────────────────────────────────

async function loadArticles() {
  const grid = document.getElementById('articles-grid');
  if (!grid) return;

  // Loading state
  grid.innerHTML = `
    <div class="dynamic-loading" role="status" aria-live="polite">
      <span class="dynamic-loading__spinner" aria-hidden="true"></span>
      Loading articles…
    </div>`;

  try {
    const response = await fetch(`${API_BASE}/api/articles`);

    if (!response.ok) {
      throw new Error(`Server error: ${response.status} ${response.statusText}`);
    }

    const articles = await response.json();

    if (articles.length === 0) {
      grid.innerHTML = `<p class="dynamic-empty">No articles available at this time.</p>`;
      return;
    }

    grid.innerHTML = articles
      .map(
        article => `
      <article class="card card--article">
        <div class="card__thumbnail card__thumbnail--no-image">
          <span class="card__category">${escapeHtml(article.slug.split('-').slice(-2).join(' '))}</span>
        </div>
        <div class="card__body">
          <div class="card__meta">
            <time class="card__date" datetime="${Array.isArray(article.publishedAt) ? article.publishedAt.join('-') : article.publishedAt}">
              ${formatDate(article.publishedAt)}
            </time>
          </div>
          <h3 class="card__title">${escapeHtml(article.title)}</h3>
          <p class="card__excerpt">${escapeHtml(article.summary)}</p>
          <a href="#articles" class="card__link">Read Article &rarr;</a>
        </div>
      </article>`
      )
      .join('');
  } catch (err) {
    console.error('[Quiroga API] Failed to load articles:', err);
    grid.innerHTML = `
      <div class="dynamic-error" role="alert">
        <strong>Unable to load articles.</strong>
        <br>Please check your connection or try again later.
      </div>`;
  }
}

// ─── Team ─────────────────────────────────────────────────────────────────────

async function loadTeam() {
  const grid = document.getElementById('team-grid');
  if (!grid) return;

  // Loading state
  grid.innerHTML = `
    <div class="dynamic-loading" role="status" aria-live="polite">
      <span class="dynamic-loading__spinner" aria-hidden="true"></span>
      Loading team members…
    </div>`;

  try {
    const response = await fetch(`${API_BASE}/api/team`);

    if (!response.ok) {
      throw new Error(`Server error: ${response.status} ${response.statusText}`);
    }

    const members = await response.json();

    if (members.length === 0) {
      grid.innerHTML = `<p class="dynamic-empty">No team members found.</p>`;
      return;
    }

    grid.innerHTML = members
      .map(member => {
        const initials = getInitials(member.name);
        return `
      <article class="card card--profile">
        <div class="card__image-wrapper">
          <div class="card__avatar" aria-hidden="true">${escapeHtml(initials)}</div>
          <div class="card__image-overlay">
            <div class="card__social">
              <a href="#team" class="card__social-link" aria-label="View ${escapeHtml(member.name)}'s profile">&#8594;</a>
            </div>
          </div>
        </div>
        <div class="card__body">
          <h3 class="card__name">${escapeHtml(member.name)}</h3>
          <p class="card__role">${escapeHtml(member.role)}</p>
          <p class="card__bio">${escapeHtml(member.bio)}</p>
        </div>
      </article>`;
      })
      .join('');
  } catch (err) {
    console.error('[Quiroga API] Failed to load team:', err);
    grid.innerHTML = `
      <div class="dynamic-error" role="alert">
        <strong>Unable to load team information.</strong>
        <br>Please check your connection or try again later.
      </div>`;
  }
}

// ─── Success Stories / Victories ──────────────────────────────────────────────

async function loadVictories() {
  const container = document.getElementById('victories-grid');
  if (!container) return;

  // Loading state
  container.innerHTML = `
    <div class="dynamic-loading dynamic-loading--light" role="status" aria-live="polite">
      <span class="dynamic-loading__spinner" aria-hidden="true"></span>
      Loading victories…
    </div>`;

  try {
    const response = await fetch(`${API_BASE}/api/success`);

    if (!response.ok) {
      throw new Error(`Server error: ${response.status} ${response.statusText}`);
    }

    const stories = await response.json();

    if (stories.length === 0) {
      container.innerHTML = `<p class="dynamic-empty dynamic-empty--light">No victories found.</p>`;
      return;
    }

    container.innerHTML = stories
      .map(
        story => `
      <article class="victory-card">
        <div class="victory-card__header">
          <span class="victory-card__type">${escapeHtml(story.caseType)}</span>
          <time class="victory-card__date">${formatDate(story.date)}</time>
        </div>
        <span class="victories__quote" aria-hidden="true">&ldquo;</span>
        <h3 class="victory-card__title">${escapeHtml(story.title)}</h3>
        <p class="victory-card__story">${escapeHtml(story.story)}</p>
        <p class="victories__name">— ${escapeHtml(story.clientName)}</p>
      </article>`
      )
      .join('');
  } catch (err) {
    console.error('[Quiroga API] Failed to load victories:', err);
    container.innerHTML = `
      <div class="dynamic-error dynamic-error--light" role="alert">
        <strong>Unable to load client victories.</strong>
        <br>Please check your connection or try again later.
      </div>`;
  }
}

// ─── XSS Guard ────────────────────────────────────────────────────────────────

function escapeHtml(str) {
  if (str == null) return '';
  return String(str)
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;')
    .replace(/'/g, '&#39;');
}

// ─── Bootstrap ────────────────────────────────────────────────────────────────

document.addEventListener('DOMContentLoaded', () => {
  loadArticles();
  loadTeam();
  loadVictories();
});
