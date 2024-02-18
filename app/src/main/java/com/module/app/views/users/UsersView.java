package com.module.app.views.users;

import com.module.app.data.SamplePerson;
import com.module.app.services.SamplePersonService;
import com.module.app.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Users")
@Route(value = "users", layout = MainLayout.class)
@RolesAllowed("ADMIN")
@Uses(Icon.class)
public class UsersView extends Composite<VerticalLayout> {

    public UsersView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Grid<SamplePerson> basicGrid = new Grid<SamplePerson>(SamplePerson.class);
        VerticalLayout layoutColumn3 = new VerticalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        TextField textField = new TextField();
        EmailField emailField = new EmailField();
        PasswordField passwordField = new PasswordField();
        Select<SampleItem> select = new Select<SampleItem>();
        Button buttonPrimary = new Button();
        getContent().addClassName(Padding.SMALL);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("100%");
        basicGrid.setWidth("100%");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(basicGrid);
        layoutColumn3.addClassName(Gap.SMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn3.setMaxWidth("320px");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn3.setAlignItems(Alignment.CENTER);
        layoutColumn4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        textField.setLabel("Complete Name");
        textField.setWidth("100%");
        emailField.setLabel("Email");
        emailField.setWidth("100%");
        passwordField.setLabel("Password");
        passwordField.setWidth("100%");
        select.setLabel("Rol");
        select.setWidth("min-content");
        setSelectSampleData(select);
        buttonPrimary.setText("Button");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(basicGrid);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(layoutColumn4);
        layoutColumn4.add(textField);
        layoutColumn4.add(emailField);
        layoutColumn4.add(passwordField);
        layoutColumn4.add(select);
        layoutColumn4.add(buttonPrimary);
    }

    private void setGridSampleData(Grid<SamplePerson> grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select<SampleItem> select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
