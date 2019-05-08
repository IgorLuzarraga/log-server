package com.example.logserver.frontend;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;

import  com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@StyleSheet("frontend://styles/styles.css")
@Route
@Push
public class MainView extends VerticalLayout {
    private final static String HEADER_TEXT = "LOG SERVER";
    private final static String HEADER_THEME = "dark";
    private final static String FOOTER_THEME = "dark";
    private final static String CLASS_NAME = "main-view";

    private BuildLogLayout buildLogLayout;

    @Autowired
    public MainView(BuildLogLayout buildLogLayout) {
        this.buildLogLayout = buildLogLayout;

        setUp();
        buildHeader();
        buildLayout();
        buildFooter();
    }

    private void setUp(){
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        addClassName(CLASS_NAME);
    }

    private void buildHeader(){
        H1 header = new H1(HEADER_TEXT);
        header.getElement().getThemeList().add(HEADER_THEME);
        add(header);
    }

    private void buildLayout(){
        add(buildLogLayout);
    }

    private void buildFooter(){
        Footer footer = new Footer();
        footer.getElement().getThemeList().add(FOOTER_THEME);
        add(footer);
    }
}
