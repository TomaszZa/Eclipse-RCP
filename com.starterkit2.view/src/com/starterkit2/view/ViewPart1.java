package com.starterkit2.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

import com.starterkit2.view.model.Person;

public class ViewPart1 extends ViewPart {
	private Text text;
	private Text text_1;

	public ViewPart1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(3, false));
		
		Label lblFirstName = new Label(parent, SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFirstName.setText("First Name:");
		
		text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnTest = new Button(parent, SWT.NONE); //SWT jaki typ elementu
		btnTest.setText("Test");
		
		Label lblLastName = new Label(parent, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastName.setText("Last Name");
		
		text_1 = new Text(parent, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		// TODO Auto-generated method stub
        btnTest.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_1.setText(text.getText());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        Person p = new Person();
        DataBindingContext ctx = new DataBindingContext();
        IObservableValue target = WidgetProperties.text(SWT.Modify).observe(text);
        IObservableValue model = BeanProperties.value(Person.class, "firstName").observe(p);
        ctx.bindValue(target, model);
        IObservableValue target2 = WidgetProperties.text(SWT.Modify).observe(text_1);
        ctx.bindValue(target2,model);
        		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
