package com.starterkit2.view;



import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory1 implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
	    String editorArea = layout.getEditorArea();
	    layout.setEditorAreaVisible(false);
	    layout.setFixed(true);

	    layout.addView("com.starterkit2.view.view1", IPageLayout.LEFT, 1.0f, editorArea);

	}

}
