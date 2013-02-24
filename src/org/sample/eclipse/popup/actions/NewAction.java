package org.sample.eclipse.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class NewAction implements IObjectActionDelegate {

	private IFile file;

	/**
	 * Constructor for Action1.
	 */
	public NewAction() {
		super();
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			file = (IFile) ssel.getFirstElement();
		}
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		try {
			IFile file1 = file.getWorkspace().getRoot().getFile(new Path("/javatest/src/JavaSample1.java"));
			IJavaElement element = JavaCore.create(file1);
			if (element.getElementType() == IJavaElement.COMPILATION_UNIT) {
				ICompilationUnit unit = (ICompilationUnit) element;
				IType type = unit.getAllTypes()[0];
				for (IMethod method : type.getMethods()) {
					System.out.println(method);
				}
			}
		} catch (Exception e) {

		}


//		MessageDialog.openInformation(
//			new Shell(),
//			"Eclipse Sample Plugin",
//			"New Action was executed. selcted fullPath = " + file.getFullPath()
//			+ ", location = " + file.getLocation());

//		IFile afile = file.getWorkspace().getRoot().getFile(new Path("/javatest/sample.txt"));
//
//		try {
//	        InputStream in = new ByteArrayInputStream("abcde".getBytes());
////	        if (file.exists()) {
////	            file.delete(true, null);
////	        }
//	        afile.create(in, true, null);
//	        in.close();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}

	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

}
