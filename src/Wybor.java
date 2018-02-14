import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

//Okienko wyboru dodawanego organizmu
public class Wybor extends JFrame{
	

	JPanel wybor = new JPanel();
	private char zn;
	public Wybor(int y,int x,Swiat swiat)
	{
		super("Wybierz Organizm do dodania");
		setSize(300,300);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		DefaultListModel listModel = new DefaultListModel();
		
		listModel.addElement("Antylopa");
		listModel.addElement("Owca");
		listModel.addElement("Lis");
		listModel.addElement("Zolw");
		listModel.addElement("Wilk");
		listModel.addElement("Cyber Owca");
		listModel.addElement("Trawa");
		listModel.addElement("Mlecz");
		listModel.addElement("Guarana");
		listModel.addElement("Wilcze Jagody");
		listModel.addElement("Barszcz Sosnowskiego");
		
		JList list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		JButton OK = new JButton("OK");
		
		OK.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) { 
	            if (list.getSelectedIndex() != -1) {                     
	              if(list.getSelectedValue() == "Antylopa")zn = 'A';
	              else if(list.getSelectedValue() == "Owca")zn = 'O';
	              else if(list.getSelectedValue() == "Lis")zn = 'L';
	              else if(list.getSelectedValue() == "Zolw")zn = 'Z';
	              else if(list.getSelectedValue() == "Wilk")zn = 'W';
	              else if(list.getSelectedValue() == "Cyber Owca")zn = 'C';
	              else if(list.getSelectedValue() == "Trawa")zn = 'T';
	              else if(list.getSelectedValue() == "Mlecz")zn = 'M';
	              else if(list.getSelectedValue() == "Guarana")zn = 'G';
	              else if(list.getSelectedValue() == "Wilcze Jagody")zn = 'J';
	              else if(list.getSelectedValue() == "Barszcz Sosnowskiego")zn = 'B';
	              else zn = ' ';
	              
	              if(zn!=' ')
	              swiat.dodajZwierze(y, x, zn);
	              dispose();
	            }
	         }
				});
		wybor.add(OK);
		wybor.add(list);
		
		
		add(wybor);
	}
	public void wybierz()
	{
		
		
		
	}
	public char getZnak(){return zn;}
}
