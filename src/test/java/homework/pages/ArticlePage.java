package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
    BaseFunc baseFunc;
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'text-size-19')]");

    public ArticlePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public Integer getCommentsCount() {
        String comments = baseFunc.getElement(COMMENTS_COUNT).getText();
        comments = comments.substring(1, comments.length() - 1);
        return Integer.valueOf(comments);
    }

    public WebElement getCommentsById(int id){
        return baseFunc.getElements(COMMENTS_COUNT).get(id);
    }

    public CommentsPage goToComments(int id){
        getCommentsById(id).click();
        return new CommentsPage(baseFunc);
    }

}
