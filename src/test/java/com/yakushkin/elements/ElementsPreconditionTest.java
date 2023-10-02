package com.yakushkin.elements;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

@SpringBootTest
public class ElementsPreconditionTest {

    @BeforeAll
    static void openElementsBlock() {
        open("https://demoqa.com/elements");
        final SelenideElement elementSection = $x("//div[text()='Elements' and @class='header-text']/../../parent::div[@class='element-group']")
                .shouldBe(exist);
        if (!elementSection.$x("./div").has(attribute("class", "element-list collapse show"))) {
            $x("//div[text()='Elements' and @class='header-text']")
                    .shouldBe(and("present", visible, exist), ofSeconds(10))
                    .click();
            elementSection.$x("./div")
                    .shouldHave(attribute("class", "element-list collapse show"), ofSeconds(5));
        }
    }
}
