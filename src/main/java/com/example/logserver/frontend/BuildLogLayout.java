package com.example.logserver.frontend;

import com.example.logserver.domain.LogMessage;
import com.example.logserver.receiver.LogReceiver;
import com.example.logserver.services.LogMsgService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class BuildLogLayout extends VerticalLayout {
    private final String GRID_COLUMN_ONE = "log";
    private final String CLEAR_ALL_BUTTON_TEXT = "Clear All";
    private final LogReceiver logReceiver;
    private final LogMsgService logMsgService;

    private Grid<LogMessage> grid;
    private Button CleanAllBtn;

    @Autowired
    public BuildLogLayout(LogReceiver logReceiver,
                          LogMsgService logMsgService) {
        this.logReceiver = logReceiver;
        this.logMsgService = logMsgService;

        buildLayout();
        setUpClearAllBtn();

        // Receive the logs msgs
        setUpLogReceiver();

        addLogsToGrid();
    }

    private void setUpLogReceiver(){
        // send the behaviour to implement when the logReceiver
        // receives a los message.
        /*
        logReceiver.setAddLogsToGrid( log -> {
            addLogsToGrid(log);
        });
        */
        logReceiver.setAddLogsToGrid(this::addLogsToGrid);
    }

    private void addLogsToGrid(String log){
        logMsgService.save(new LogMessage(log));

        getUI().ifPresent(ui ->
                ui.access(() -> addLogsToGrid())
        );
    }

    private void addLogsToGrid(){
        grid.setItems(logMsgService.findAll());
    }

    private void buildLayout() {
        grid = new Grid<>(LogMessage.class);
        CleanAllBtn = new Button(CLEAR_ALL_BUTTON_TEXT, VaadinIcon.TRASH.create());

        grid.setHeight("400px");
        grid.setColumns(GRID_COLUMN_ONE);
        grid.getColumnByKey(GRID_COLUMN_ONE).setWidth("100%").setFlexGrow(0);

        add(CleanAllBtn, grid);
    }

    private void setUpClearAllBtn(){
        CleanAllBtn.setWidth("250px");

        CleanAllBtn.addClickListener(e -> cleanAll());
    }

    public void cleanAll(){
        logMsgService.deleteAll();
        addLogsToGrid();
    }
}







