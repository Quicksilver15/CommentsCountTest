package homework.pages;

import org.openqa.selenium.By;

public class CommentsPage {
    BaseFunc baseFunc;
    private final By REG_COMMENTS = By.xpath(".//a[contains(@class, 'comment-thread-switcher-list-a-reg')]");
    private final By ANON_COMMENTS = By.xpath(".//a[contains(@class, 'comment-thread-switcher-list-a-anon')]");

    public CommentsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Integer getRegComments() {
        String regComments = baseFunc.getElement(REG_COMMENTS).getText();
        regComments = regComments.substring(13, regComments.length() - 1);
        return Integer.valueOf(regComments);
    }

    public Integer getAnonComments() {
        String anonComments = baseFunc.getElement(ANON_COMMENTS).getText();
        anonComments = anonComments.substring(10, anonComments.length() - 1);
        return Integer.valueOf(anonComments);
    }

    public Integer getCommentsCount() {
        Integer commentsCount = getRegComments() + getAnonComments();
        return Integer.valueOf(commentsCount);
    }

}
