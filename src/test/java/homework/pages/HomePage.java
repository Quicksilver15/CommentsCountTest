package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    BaseFunc baseFunc;
    private final By ARTICLE = By.xpath(".//span[contains(@class, 'text-size-19')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Integer getCommentsCountById(int id) {
        WebElement article = getArticleById(id);
        String commentsCount = article.findElement(COMMENTS_COUNT).getText();
        commentsCount = commentsCount.substring(1, commentsCount.length() - 1);
        return Integer.valueOf(commentsCount);
    }

    public WebElement getArticleById(int id) {
        return baseFunc.getElements(ARTICLE).get(id);
    }

    public ArticlePage goToArticle(int id){
        getArticleById(id).click();
        return new ArticlePage(baseFunc);
    }

}
