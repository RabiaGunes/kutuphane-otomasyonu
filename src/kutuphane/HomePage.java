package kutuphane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane; 



public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField newBookText;
	
	static JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JScrollPane pane;
	
	static JTable table2 = new JTable();
	DefaultTableModel model2 = new DefaultTableModel();
	JScrollPane pane2;
	
	static JTable table3 = new JTable();
	DefaultTableModel model3 = new DefaultTableModel();
	JScrollPane pane3;
	
	ResultSet rs;
	private JTextField rezerveText;
	static LocalDate dateDelivery;
	String del_date;
	ArrayList<String> days_string = new ArrayList<String>();
	private JLabel kutup1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					HomePage frame = new HomePage(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	public HomePage(userManage manage) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      HOME PAGE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 0, 224, 33);
		contentPane.add(lblNewLabel);
		

		
		
		//JButton ArchiveButon = new JButton("My Archive");
	//	ArchiveButon.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {
				
				 pane = new JScrollPane(table);
				 pane.setBounds(618,71, 400, 225);
				 contentPane.add(pane);
				
				Object column_header[]= {"book_name","book_date","delivery_date"};
				model.setColumnIdentifiers(column_header);
				table.setModel(model);
				table.setRowHeight(30);
				table.setBounds(618, 71, 400, 198);
				
				
				
			     pane3 = new JScrollPane(table3);
					 pane3.setBounds(489,435,498,200);
					 contentPane.add(pane3);
					
					Object column_header3[]= {"teslim günleri icin bilgilendirme"};
					model3.setColumnIdentifiers(column_header3);
					table3.setModel(model3);
					table3.setRowHeight(30);
					table3.setBounds(489,435,498,200);
				
					
				
				workData data = new workData();
				rs = data.kullaniciArsivGetir(manage);
				
				
				try {
					if(rs != null) {
						model.addRow(new Object[]{rs.getString("book_name"),rs.getString("book_date"), rs.getString("delivery_date")});
						while(rs.next())
							model.addRow(new Object[]{rs.getString("book_name"),rs.getString("book_date"), rs.getString("delivery_date")});
					}
				} catch (SQLException e1) {
		
					e1.printStackTrace();
				}
				
		//	}
	//	});
		
		
	//	ArchiveButon.setBackground(new Color(184, 134, 11));
	//	ArchiveButon.setFont(new Font("Tahoma", Font.BOLD, 15));
	//	ArchiveButon.setBounds(722, 13, 166, 33);
	//	contentPane.add(ArchiveButon);
	
		JButton addBookButon = new JButton("Rezerve Et");
		addBookButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String book_name;
				
				if(newBookText.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"please enter a book name");	
				
				}
				else {
					
					 book_name = newBookText.getText().toString();
						
						LocalDateTime myDateObj = LocalDateTime.now();
					    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

					    String formattedDate = myDateObj.format(myFormatObj);
					    LocalDate today = LocalDate.now();
						  
					    LocalDate delivery_date = today.plusDays(Integer.parseInt(rezerveText.getText()));
					 
						String date = delivery_date.toString();
						
						workData data = new workData();
						data.kitapEkle(manage,book_name,formattedDate,date);
						
					
				}
				
			}
		});
		
		
	/*    public Component duzelt (JTable renderer, int rowIndex, int columnIndex){
	        Component componenet = super.duzelt(renderer, rowIndex, columnIndex);

	        Object value = getModel().getValueAt(rowIndex,columnIndex);

	        if(columnIndex == 4){

	            if(value.equals("On Time"))
	            {

	                componenet.setBackground(Color.GREEN);
	                componenet.setForeground(Color.BLACK);

	            }
	            if(value.equals("Arrived")){
	                // if date  equal current date
	                componenet.setBackground(Color.BLUE);
	                componenet.setForeground(Color.BLACK);
	            }
		
	        }
	    } */
		
		
		
		 pane2 = new JScrollPane(table2);
		 pane2.setBounds(30,71,466,225);
		 contentPane.add(pane2);

		Object column_header2[]= {"seri_no","name","author","page"};
		model2.setColumnIdentifiers(column_header2);
		table2.setModel(model2);
		table2.setRowHeight(30);
		table2.setBounds(30, 71, 466,225);
		
	
		
		workData data2 = new workData();
		ResultSet rs2 = data2.kitaplariGetir();
		
		
		try {
			if(rs2 != null) {
				model2.addRow(new Object[]{rs2.getString("seri_no"),rs2.getString("name"), rs2.getString("author"),rs2.getString("page")});
				while(rs2.next())
					model2.addRow(new Object[]{rs2.getString("seri_no"),rs2.getString("name"), rs2.getString("author"),rs2.getString("page")});
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		table2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				int i = table2.getSelectedRow();
				System.out.print(model2.getValueAt(i,1)+"---i:"+i);
				newBookText.setText((String) model2.getValueAt(i,1));
				
			}
			
		});
		


		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    
	   ResultSet rs3=new workData().kullaniciArsivGetir(manage);
	   
	   
	   if(rs3 != null) {
	   		try {
	   			days_string.add(rs3.getString("delivery_date"));
	   			while(rs3.next()) {
	   			days_string.add(rs3.getString("delivery_date"));
	   			}
	   			} catch (SQLException e2) {
		
	   					e2.printStackTrace();
	   				}
	   		}
	   
	   SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	   java.util.Date d1 = null;
	   
	   java.util.Date d2 = new java.util.Date();
	   System.out.println("----now date : "+sdformat.format(d2));
	   
	  

	   for(int i=0;i<days_string.size();i++) {	
	      
			try {
				d1 = sdformat.parse(days_string.get(i));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		     
		
		      System.out.println("teslim tarihi : " + sdformat.format(d1));
		     System.out.println("bugunun tarihi: " + sdformat.format(d2));
		     
		     
		   
		     
		      if(d1.compareTo(d2) < 0 ) {
		    	  long zaman = d1.getTime() - d2.getTime();
  
		    	  if(TimeUnit.DAYS.convert(zaman, TimeUnit.MILLISECONDS)!=0) {
		    		  
		    		  System.out.println("teslim zamani "+TimeUnit.DAYS.convert(zaman, TimeUnit.MILLISECONDS)+" gun geçti\n\n");
		    		  
		    		  model3.addRow(new Object[]{model.getValueAt(i,0)+" teslim zamani "+TimeUnit.DAYS.convert(zaman, TimeUnit.MILLISECONDS)+" gun geçti"});
		    		  
		    	  }	
		    	  else {
		    		  System.out.println("teslim gunu bugun\n\n");
		    		model3.addRow(new Object[]{model.getValueAt(i,0)+" teslim gunu bugun"});
		    		table3.setForeground(Color.GREEN);
		    	  }
		      } else if(d1.compareTo(d2) > 0) {
		    	  
		    	  long zaman2 = d1.getTime() - d2.getTime() ;
		         System.out.println("teslim zamanina henuz "+(TimeUnit.DAYS.convert(zaman2, TimeUnit.MILLISECONDS)+1)+" gun var\n\n");
		     	model3.addRow(new Object[]{model.getValueAt(i,0)+" teslim zamanina henuz "+(TimeUnit.DAYS.convert(zaman2, TimeUnit.MILLISECONDS)+1)+" gun var"});
		     	table3.setForeground(Color.GREEN);
		      }
	   
		   //System.out.println(days_string.get(i));
	   }
	   
	
	   
	   

		
		addBookButon.setBackground(Color.WHITE);
		addBookButon.setFont(new Font("Tahoma", Font.BOLD, 15));
		addBookButon.setBounds(29, 584, 124, 33);
		contentPane.add(addBookButon);
		
		newBookText = new JTextField();
		newBookText.setFont(new Font("Tahoma", Font.BOLD, 16));
		newBookText.setBackground(SystemColor.text);
		newBookText.setBounds(29, 530, 252, 22);
		contentPane.add(newBookText);
		newBookText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("kac gunlugune rezerve edilecek");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(25, 431, 224, 22);
		contentPane.add(lblNewLabel_2);
		
		rezerveText = new JTextField();
		rezerveText.setFont(new Font("Tahoma", Font.BOLD, 16));
		rezerveText.setBounds(29, 479, 67, 22);
		contentPane.add(rezerveText);
		rezerveText.setColumns(10);
		
		JLabel kutup = new JLabel("Kütüphane Kitaplarý");
		kutup.setBackground(new Color(0, 0, 0));
		kutup.setForeground(new Color(107, 142, 35));
		kutup.setFont(new Font("Tahoma", Font.BOLD, 21));
		kutup.setBounds(123, 36, 263, 22);
		contentPane.add(kutup); 
		
		JLabel arsivim = new JLabel("Üzerimdekiler");
		arsivim.setBackground(new Color(199, 21, 133));
		arsivim.setForeground(new Color(0, 139, 139));
		arsivim.setFont(new Font("Tahoma", Font.BOLD, 21));
		arsivim.setBounds(726, 36, 205, 22);
		contentPane.add(arsivim);
	
		
		JLabel labelBack = new JLabel("");
		labelBack.setBounds(0, 338, 1036, 415);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/turk.png"));
		labelBack.setIcon(img);
		contentPane.add(labelBack);
		
		JLabel label2 = new JLabel("");
		label2.setBounds(0, 0, 768, 337);
		contentPane.add(label2);
		
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/kitapOkuma.jpg"));
		label2.setIcon(img2);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("New label");
		label3.setBounds(768, 0, 250, 337);
		contentPane.add(label3);
		ImageIcon img3 = new ImageIcon(this.getClass().getResource("/kitaplar.jpg"));
		label3.setIcon(img3);
		contentPane.add(label3);
		
		
		
	
		
		
		
		newBookText.setVisible(true);
		
	}
}
