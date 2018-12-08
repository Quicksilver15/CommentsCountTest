package homework;

import homework.pages.ArticlePage;
import homework.pages.BaseFunc;
import homework.pages.CommentsPage;
import homework.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentsCountTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "delfi.lv";

    @Test
    public void delfiCommentsCheck() {

        baseFunc.goToPage(HOME_PAGE);

        HomePage homePage = new HomePage(baseFunc);
        Integer commentsCount = homePage.getCommentsCountById(1);

        ArticlePage articlePage = homePage.goToArticle(1);
        Integer articlePageComments = articlePage.getCommentsCount();

        CommentsPage commentsPage = articlePage.goToComments(0);
        Integer commentsPageComments = commentsPage.getCommentsCount();

        Assertions.assertEquals(commentsCount, articlePageComments, "Homepage comments are not equal to Articlepage comments");

        Assertions.assertEquals(commentsCount, commentsPageComments, "Homepage comments are not equal to Commentspage comments");

        baseFunc.CloseBrowser();

    }

}
