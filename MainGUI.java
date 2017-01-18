package edu.pitt;
//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Rebecca Ly & Joe Bender
 */
public class MainGUI {
    //declarations
	private JFrame mainFrame;
	private JLabel title;
	private JLabel name;
	private JLabel color;
	private JLabel bgcolor;
	private JLabel x;
	private JLabel y;
	private JLabel ftstyle;
	private JLabel ftsize;
        private JLabel message;
        private JPanel mainPanel;
        public Font newfont;
	private JPanel bannerPanel;
        private JLabel bannermessage;
        public String messageinput;
	private JTextField txtName;
	private JComboBox comboColor;
	private JComboBox comboBGColor;
	private JComboBox comboX;
	private JComboBox comboY;
	private JRadioButton btnFTStyle;
	private JSlider sliderFTSize;
	private JTextField txtSize;
	    
        //call gui builder
	public MainGUI(){
		buildingGUI();
	}
           //main method, create instance of MainGUI
	public static void main(String[] args) {
		MainGUI BannerGUI = new MainGUI();
	}	
	// Builds the GUI
		private void buildingGUI() {     
                        //Build Frame and set layout
			mainFrame = new JFrame("Banner Applet"); // Sets title of the GUI
                        mainFrame.setVisible(true);
			mainFrame.setSize(1000, 700); // Sets size of GUI
			mainFrame.setLayout(new BorderLayout()); 
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                        
                        //create main panel
                        mainPanel = new JPanel(new GridBagLayout());
                        //create banner panel
                        bannerPanel = new JPanel(new GridBagLayout());
                        //layout constraints
                        GridBagConstraints c = new GridBagConstraints();
                        c.insets = new Insets(10,10,10,10);
                        c.weightx = 1;
                        c.fill=GridBagConstraints.HORIZONTAL;
                       
			// Title Panel
			title = new JLabel("Create Your Own Banner!");
			
			// Message Panel
			name = new JLabel("Message to display: ");
			
                        //Message Input
			txtName = new JTextField(); // Instantiates text field
			
                        //Sets default message
                        bannermessage = new JLabel("Default Banner");
                        
                        //Message field with auto updating listener
                        txtName.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e){
					messageinput = txtName.getText();
					bannermessage.setText(messageinput);
				}
			});
			//establishes default font
                        Font baseFont = new Font("Serif", Font.PLAIN, 20);
                        //sets default font
                        bannermessage.setFont(baseFont);
                        
                        //Create 4 buttons with listeners to change font style in banner
                        JButton boldButton=new JButton("Bold");
                        
                        boldButton.addActionListener(new ActionListener()
                            {
                              public void actionPerformed(ActionEvent e)
                              {
                                Font font = bannermessage.getFont();
                                bannermessage.setFont(font.deriveFont(font.getStyle() ^ Font.BOLD));
                              }
                            });
                        
                        JButton italicButton=new JButton("Italic");
                        
                        italicButton.addActionListener(new ActionListener()
                            {
                              public void actionPerformed(ActionEvent e)
                              {
                                Font font = bannermessage.getFont();
                                bannermessage.setFont(font.deriveFont(font.getStyle() ^ Font.ITALIC));
                              }
                            });
                        
                        JButton bolditalicButton=new JButton("Bold Italic");
                        
                        bolditalicButton.addActionListener(new ActionListener()
                            {
                              public void actionPerformed(ActionEvent e)
                              {
                                Font font = bannermessage.getFont();
                                bannermessage.setFont(font.deriveFont(font.getStyle() ^ Font.BOLD ^ Font.ITALIC));
                              }
                            });
                        
                        JButton regButton=new JButton("Plain");
                        
                        regButton.addActionListener(new ActionListener()
                            {
                              public void actionPerformed(ActionEvent e)
                              {
                                bannermessage.setFont(baseFont);
                              }
                            });
                        
			// Color Panel
			color = new JLabel("Font Color: ");
			
                       
			String[] colors = {"Black", "Blue", "White", "Cyan"};
			JComboBox<String> comboColors  = new JComboBox<>(colors);
			comboColors.addActionListener (new ActionListener () {
                                public void actionPerformed(ActionEvent e) {
                                    if(comboColors.getSelectedItem().toString() == "White")
                                    bannermessage.setForeground(Color.white);
                                    if(comboColors.getSelectedItem().toString() == "Black")
                                    bannermessage.setForeground(Color.black);
                                    if(comboColors.getSelectedItem().toString() == "Blue")
                                    bannermessage.setForeground(Color.blue);
                                    if(comboColors.getSelectedItem().toString() == "Cyan")
                                    bannermessage.setForeground(Color.cyan);
                                }
                            });
                        
			
			// Background Color Panel
			bgcolor = new JLabel("Banner Background Color: ");
			
			String[] bgcolors = {"Black", "Blue", "White", "Cyan"};
			JComboBox<String> comboBGColor  = new JComboBox<>(bgcolors);
			
                        //Dropdown with listener to change applet background color
                        comboBGColor.addActionListener (new ActionListener () {
                                public void actionPerformed(ActionEvent e) {
                                    if(comboBGColor.getSelectedItem().toString() == "White")
                                    bannerPanel.setBackground(Color.white);
                                    if(comboBGColor.getSelectedItem().toString() == "Black")
                                    bannerPanel.setBackground(Color.black);
                                    if(comboBGColor.getSelectedItem().toString() == "Blue")
                                    bannerPanel.setBackground(Color.blue);
                                    if(comboBGColor.getSelectedItem().toString() == "Cyan")
                                    bannermessage.setForeground(Color.cyan);
                                }
                            });
                        
			
			// Font Style Panel
			ftstyle = new JLabel("Font Style: ");
			
			// Font Size Panel
			ftsize = new JLabel("Font Size: ");
			//ftsize.setBounds(5, 215, 150, 30);
			txtSize = new JTextField();
			//txtSize.setBounds(150,215,100,30);
                        
                        
                        //creates slider with listener to change font size
			sliderFTSize = new JSlider(10, 20, 10);
			
			sliderFTSize.addChangeListener(new ChangeListener(){
				public void stateChanged(ChangeEvent e){
					txtSize.setText(String.valueOf(sliderFTSize.getValue()));
                                        int val1 = sliderFTSize.getValue();
                                        Font currentfont = bannermessage.getFont();
                                        
                                        Font fontsize = currentfont.deriveFont((float)val1);
                                        
                                        bannermessage.setFont(fontsize);

				}
			})
			;
                        //creates text field with listener to change font size
			txtSize = new JTextField(); 
			
			txtSize.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e){
					
					String val1 = txtSize.getText();
                                        int i = Integer.parseInt(val1);
                                        Font currentfont = bannermessage.getFont();
                                        Font fontsize = currentfont.deriveFont((float)i);
                                        bannermessage.setFont(fontsize);
				}
			});
			
			// Display all components with layout constraints
                        
                        //title
                        c.gridx = 0;
                        c.gridy = 1;
			mainPanel.add(title,c);
                        //text color
                        c.gridx = 0;
                        c.gridy = 2;
			mainPanel.add(color,c);
                        c.gridx = 1;
                        c.gridy = 2;
			mainPanel.add(comboColors,c);
                        //message input
                        c.gridx = 0;
                        c.gridy = 3;
			mainPanel.add(name,c);
                        c.gridx = 1;
                        c.gridy = 3;
			mainPanel.add(txtName,c);
                        //applet background color
                        c.gridx = 0;
                        c.gridy = 4;
			mainPanel.add(bgcolor,c);
                        c.gridx = 1;
                        c.gridy = 4;
			mainPanel.add(comboBGColor,c);
                        //font style buttons
                        c.gridx = 0;
                        c.gridy = 5;
			mainPanel.add(ftstyle,c);
                        c.gridx = 1;
                        c.gridy = 5;
			mainPanel.add(regButton,c);
                        c.gridx = 2;
                        c.gridy = 5;
			mainPanel.add(italicButton,c);
                        c.gridx = 3;
                        c.gridy = 5;
			mainPanel.add(boldButton,c);
                        c.gridx = 4;
                        c.gridy = 5;
			mainPanel.add(bolditalicButton,c);
                        //sont size slider and text input
                        c.gridx = 0;
                        c.gridy = 6;
			mainPanel.add(ftsize,c);
                        c.gridx = 1;
                        c.gridy = 6;
			mainPanel.add(sliderFTSize,c);
                        c.gridx = 2;
                        c.gridy = 6;
			mainPanel.add(txtSize,c);
                        

                        //add banner message to banner panel
                        bannerPanel.add(bannermessage);
                        //add main panel with components to frame on top
                        mainFrame.add(mainPanel,BorderLayout.NORTH);
                        //add banner panel with banner to frame on bottom
                        mainFrame.add(bannerPanel, BorderLayout.SOUTH);
                        //pack the frame to display elements
                        mainFrame.pack();
			
    }
}