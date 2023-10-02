package com.yakushkin.elements;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

@SpringBootTest
public class RadioButtonTest extends ElementsPreconditionTest {

    @Test
    void verifyRadioButtonSection() {
        $x("//div[@class='element-list collapse show']/ul[@class='menu-list']/li[@id='item-2']")
                .shouldBe(visible, ofSeconds(10))
                .shouldHave(textCaseSensitive("Radio Button"))
                .click();
    }
}
