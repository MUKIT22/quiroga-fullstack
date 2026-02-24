package com.quiroga.lawapi.service;

import com.quiroga.lawapi.model.Article;
import com.quiroga.lawapi.model.SuccessStory;
import com.quiroga.lawapi.model.TeamMember;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContentRepository {

    private final List<Article> articles = List.of(
            new Article(
                    1L,
                    "Understanding Personal Injury Claims",
                    "understanding-personal-injury-claims",
                    "Key steps to protect your rights after an accident.",
                    "After an accident, document everything, seek medical attention, and speak with legal counsel early.",
                    LocalDate.of(2026, 1, 10)
            ),
            new Article(
                    2L,
                    "What to Expect in an Immigration Consultation",
                    "immigration-consultation-expectations",
                    "Prepare your documents and timeline before your first visit.",
                    "Bring identification, notices, and prior filings so your attorney can evaluate options quickly.",
                    LocalDate.of(2026, 1, 28)
            ),
            new Article(
                    3L,
                    "Workers' Compensation: Common Mistakes",
                    "workers-compensation-common-mistakes",
                    "Avoid delays by filing accurately and on time.",
                    "Missed deadlines and incomplete forms are common reasons claims get delayed or denied.",
                    LocalDate.of(2026, 2, 14)
            )
    );

    private final List<TeamMember> teamMembers = List.of(
            new TeamMember(
                    1L,
                    "Ana Quiroga",
                    "Founding Attorney",
                    "Over 15 years representing families in immigration and civil matters.",
                    "https://example.com/images/ana-quiroga.jpg"
            ),
            new TeamMember(
                    2L,
                    "Luis Ramirez",
                    "Senior Associate",
                    "Focuses on personal injury litigation and settlement strategy.",
                    "https://example.com/images/luis-ramirez.jpg"
            ),
            new TeamMember(
                    3L,
                    "Marisol Vega",
                    "Client Relations Manager",
                    "Guides clients through documentation and case status updates.",
                    "https://example.com/images/marisol-vega.jpg"
            )
    );

    private final List<SuccessStory> successStories = List.of(
            new SuccessStory(
                    1L,
                    "Six-Figure Auto Collision Settlement",
                    "J. M.",
                    "Personal Injury",
                    "Our team secured a six-figure settlement after proving long-term medical impact and lost income.",
                    LocalDate.of(2025, 11, 20)
            ),
            new SuccessStory(
                    2L,
                    "Family Reunification Approved",
                    "C. R.",
                    "Immigration",
                    "We built a complete petition package that led to approval and reunification within expected processing time.",
                    LocalDate.of(2025, 12, 5)
            ),
            new SuccessStory(
                    3L,
                    "Denied Claim Reopened Successfully",
                    "P. S.",
                    "Workers' Compensation",
                    "After appeal, the claim was reopened and benefits were restored with retroactive payment.",
                    LocalDate.of(2026, 1, 18)
            )
    );

    public List<Article> findAllArticles() {
        return articles;
    }

    public Optional<Article> findArticleById(Long id) {
                return articles.stream().filter(article -> article.getId().equals(id)).findFirst();
    }

    public List<TeamMember> findAllTeamMembers() {
        return teamMembers;
    }

    public Optional<TeamMember> findTeamMemberById(Long id) {
                return teamMembers.stream().filter(member -> member.getId().equals(id)).findFirst();
    }

    public List<SuccessStory> findAllSuccessStories() {
        return successStories;
    }

    public Optional<SuccessStory> findSuccessStoryById(Long id) {
                return successStories.stream().filter(story -> story.getId().equals(id)).findFirst();
    }
}