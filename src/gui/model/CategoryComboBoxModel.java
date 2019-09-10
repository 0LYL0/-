package gui.model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category>{
//	public List<String> cs = new ArrayList<String>();
//	String c;
	public List<Category> cs = new CategoryService().list();
	public Category c;
	public CategoryComboBoxModel(){
//		cs.add("餐饮");
//		cs.add("交通");
//		cs.add("住宿");
//		cs.add("花费");
		if(!cs.isEmpty())
		c = cs.get(0);
	}
	@Override
	public int getSize(){
		return cs.size();
	}
	@Override
	public Category getElementAt(int index){
		return cs.get(index);
	}
	@Override
	public void addListDataListener(ListDataListener l){
		
	}
	@Override
	public void removeListDataListener(ListDataListener l){
		
	}
	@Override
	public void setSelectedItem(Object anItem){
		c=(Category)anItem;
	}
	@Override
	public Object getSelectedItem(){
		return c;
	}

}
