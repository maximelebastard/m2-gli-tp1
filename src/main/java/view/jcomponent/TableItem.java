package view.jcomponent;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import model.IItemListAdapter;
import view.jcomponent.tableModel.TableModelItem;

/**
 * The items table
 * 
 * @author maxime
 *
 */
public class TableItem extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * The model to display in the table
	 */
	private TableModelItem tableModelItem;

	/**
	 * Constructs a table item
	 * @param pModel The model to represent
	 */
	public TableItem(IItemListAdapter pModel) {
		super();
		tableModelItem = new TableModelItem(pModel);
		JTable jtable = new JTable(tableModelItem);
		jtable.setModel(tableModelItem);
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		JButton buttonAdd = new JButton();
		buttonAdd.setText("Add");
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		this.add(scrollPane);
		this.add(buttonAdd);
		buttonAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tableModelItem.addRow();
			}
		});

	}
}
