package view.jcomponent.tableModel;

import javax.swing.table.AbstractTableModel;

import model.IItemListAdapter;
import model.Item;

public class TableModelItem extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private IItemListAdapter model;

	public TableModelItem(IItemListAdapter pModel) {
		super();
		model = pModel;
	}

	public int getRowCount() {
		return model.getItems().size();
	}

	public int getColumnCount() {
		return 3;
	}

	public void setValueAt(Object value, int row, int col) {
		Item item = model.getItems().get(row);

		switch (col) {
		case 0:
			item.setTitle((String) value);
			break;
		case 1:
			item.setDescription((String) value);
			break;
		case 2:
			try{
				Integer valueInt = Integer.valueOf((String) value);
				if(valueInt>=0){
					item.setNumber(valueInt);
				}
			}catch(NumberFormatException e){
				
			}
			break;
		}
		//indicate that the data has changed, now we have to notify observer
		model.newSetChanged();
		model.notifyObservers();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Item item = model.getItems().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return item.getTitle();
		case 1:
			return item.getDescription();
		case 2:
			return item.getNumber();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}

	public void addRow() {
		model.addItem(new Item());
		this.fireTableRowsInserted(0, getRowCount());
	}
}
