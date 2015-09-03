package com.starterkit2.view;


import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;

import com.starterkit2.view.model.Task;
import com.starterkit2.view.model.Tasks;

public class ToDoList extends ViewPart {
	private Text newTask;
	private Table tableActual;
	private Table tableMade;
	private Text textToEdit;

	public ToDoList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		//task list
		final Tasks tasks = new Tasks();
		
		
		parent.setToolTipText("");
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		parent.setLayout(null);
		//Text fiel 1
		Label lblTable2Name = new Label(parent, SWT.NONE);
		lblTable2Name.setAlignment(SWT.CENTER);
		lblTable2Name.setBounds(320, 70, 269, 15);
		lblTable2Name.setText("Wykonane Zadania:");
		//text field 2
		Label lblTable1Name = new Label(parent, SWT.NONE);
		lblTable1Name.setAlignment(SWT.CENTER);
		lblTable1Name.setBounds(10, 70, 272, 15);
		lblTable1Name.setText("Aktualne Zadania:");
		
		
		newTask = new Text(parent, SWT.BORDER);
		newTask.setBounds(91, 7, 393, 21);
		
		//modyfie button
		Button btnModyfie = new Button(parent, SWT.NONE);
		btnModyfie.setBounds(539, 5, 50, 25);
		btnModyfie.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnModyfie.setText("Modify");
		//text to be new title
		textToEdit = new Text(parent, SWT.BORDER);
		textToEdit.setBounds(91, 34, 393, 21);
		//actual table
		final TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableActual = tableViewer.getTable();
		//obsluga zaznaczania elemntu tabeli
		tableActual.addListener(SWT.Selection, new Listener() {
		    @Override
		    public void handleEvent(Event event) {
		    	Task toEdit = (Task) event.item.getData();
		    	tasks.setToEditOrDelete(toEdit);		    	
		    }
		});
		tableActual.setLinesVisible(true);
		tableActual.setHeaderVisible(true);
		tableActual.setBounds(10, 70, 277, 389);
		//made table
		TableViewer tableViewer_1 = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableMade = tableViewer_1.getTable();
		tableMade.setLinesVisible(true);
		tableMade.setHeaderVisible(true);
		tableMade.setBounds(315, 70, 274, 389);
		
		
		//binding
		final Task task = new Task();
		DataBindingContext ctx = new DataBindingContext();
		IObservableValue target = WidgetProperties.text(SWT.Modify).observe(newTask);
		IObservableValue model = BeanProperties.value(Task.class,"taskName").observe(task);
		ctx.bindValue(target, model);
        //add nutton
		Button btnAdd = new Button(parent, SWT.NONE);
		btnAdd.setBounds(5, 5, 81, 25);
		
		//add button
		tasks.getTasks().add(new Task("cos"));
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tasks.addTask(new Task(task.getTaskName()));
				tableViewer.refresh();
			}
		});
		btnAdd.setText("Add");
		
		//binding taskow w tabeli z lista taskow
		WritableList input = new WritableList(tasks.getTasks(), Task.class);		
	    ViewerSupport.bind(tableViewer,
	        input,
	        BeanProperties.values(new String[] { "taskName"}));
	    
	    //delete button
	    Button btnDelete = new Button(parent, SWT.NONE);
	    btnDelete.setBounds(489, 5, 45, 25);
	    btnDelete.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e){
	    		tasks.getToEditOrDelete().setTaskName(textToEdit.getText());
	    	}
	    });
	    btnDelete.setText("Delete");
	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
