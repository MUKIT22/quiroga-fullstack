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
                    "Héctor E. Quiroga",
                    "Founding Attorney",
                    " Héctor Quiroga works as a partner at the Quiroga Law Office, PLLC, where he focus his practice on immigration. He enjoys photography. He also enjoys coaching his son’s co-ed soccer team and spending time with his family..",
                    "https://example.com/images/ana-quiroga.jpg"
            ),
            new TeamMember(
                    2L,
                    "Casey Quiroga",
                    "Immigration Lawyer",
                    "Casey Quiroga is a co-founder of the Quiroga Law Office, PLLC, a firm focused solely in immigration matters. Casey’s main focus is on employment, investor, and family petitions.",
                    "https://example.com/images/luis-ramirez.jpg"
            ),
            new TeamMember(
                    3L,
                    "Maria Quiroga",
                    "Client Relations Manager",
                    "Maria joined Quiroga Law Office in June 2016 and began practicing Immigration law. She was born and raised in Bogota, Colombia. Maria immigrated to the United States with her parents in pursuit of the American dream as a young adult",
                    "https://example.com/images/marisol-vega.jpg"
            )
    );

    private final List<SuccessStory> successStories = List.of(
            new SuccessStory(
                    1L,
                    "Forever Thankful",
                    "Teresita",
                    "Client",
                    "They did a great job. Thank you for helping us in this difficult process. We are forever thankful!",
                    LocalDate.of(2025, 11, 20)
            ),
            new SuccessStory(
                    2L,
                    "Above and Beyond",
                    "Ajmal",
                    "Client",
                    "Hector and his office stood beside me every step of the way. They went above and beyond their duty to make this a reality for me. From me and my family, thank you!",
                    LocalDate.of(2025, 12, 5)
            ),
            new SuccessStory(
                    3L,
                    "Very Happy With the Results",
                    "Nubia",
                    "Client",
                    "The Quiroga Law Office and Greg helped me get through this process. They did a great job and I am very happy with the results. Thanks!",
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