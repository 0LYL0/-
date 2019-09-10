package gui.panel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import util.ColorUtil;
import util.GUIUtil;
import entity.Category;
import service.CategoryService;

public class CategoryPanel extends WorkingPanel{
	static{
		GUIUtil.useLNF();
	}
	public static CategoryPanel instance = new CategoryPanel();
	public JButton bAdd = new JButton("新增");
	public JButton bEdit = new JButton("编辑");
	public JButton bDelete = new JButton("删除");
	String columNames[] = new String[]{"分类名称","消费次数"};
	
	public CategoryTableModel ctm = new CategoryTableModel();
	public JTable t = new JTable(ctm);
	
	public CategoryPanel(){
		GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();
		pSubmit.add(bAdd);
		pSubmit.add(bEdit);
		pSubmit.add(bDelete);
		addListener();
		
		this.setLayout(new BorderLayout());
		this.add(sp,BorderLayout.CENTER);
		this.add(pSubmit,BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}
	public Category getSelectedCategory(){
		int index = t.getSelectedRow();
		return ctm.cs.get(index);
	}
	
	public void updateData(){
		ctm.cs = new CategoryService().list();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0, 0);
		if(ctm.cs.size()==0){
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		}else{
			bEdit.setEnabled(true);
			bDelete.setEnabled(true);
		}
		
	}
	public void addListener(){
		CategoryListener listener = new CategoryListener();
		bAdd.addActionListener(listener);
		bEdit.addActionListener(listener);
		bDelete.addActionListener(listener);
	}
	

}
