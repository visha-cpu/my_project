package cscorner;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class StudentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textRollNo;
	private JTextField textName;
	private JTextField textEmail;
	
	// Dynamic Driver Loading Configuration
	private static final String DRIVER_URL = "https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.0.33/mysql-connector-j-8.0.33.jar";
	private static final String JAR_NAME = "mysql-connector-j-8.0.33.jar";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Checks and downloads the JDBC driver dynamically before launching the frame
		prepareDriver();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Automatically checks for the MySQL Driver JAR and downloads it from Maven Central if missing.
	 */
	private static void prepareDriver() {
		try {
			// First, check if the driver class is already available locally in the classpath
			Class.forName("com.mysql.cj.jdbc.Driver");
			return; 
		} catch (ClassNotFoundException e) {
			System.out.println("Driver missing. Attempting automatic download...");
		}

		try {
			File jarFile = new File(JAR_NAME);
			if (!jarFile.exists()) {
				URL url = new URL(DRIVER_URL);
				try (InputStream in = url.openStream(); 
				     FileOutputStream out = new FileOutputStream(jarFile)) {
					byte[] buffer = new byte[4096];
					int bytesRead;
					while ((bytesRead = in.read(buffer)) != -1) {
						out.write(buffer, 0, bytesRead);
					}
				}
				System.out.println("Driver downloaded successfully!");
			}

			// Load the downloaded JAR file into the runtime classpath dynamically
			URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()}, StudentFrame.class.getClassLoader());
			Class<?> driverClass = Class.forName("com.mysql.cj.jdbc.Driver", true, classLoader);
			Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();
			
			// Register the dynamic driver instance with the DriverManager
			DriverManager.registerDriver(driver);
			System.out.println("Driver registered successfully via code!");

		} catch (Exception ex) {
			System.err.println("Failed to auto-load MySQL Driver: " + ex.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		setTitle("Student Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		
		// Configured with GridLayout for clean alignment of labels and input components
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setLayout(new GridLayout(4, 2, 10, 15)); 
		setContentPane(contentPane);
		
		Font commonFont = new Font("Tahoma", Font.BOLD | Font.ITALIC, 16);
		
		// ---- Roll Number Section ----
		JLabel lblRollNo = new JLabel("Enter Roll no:");
		lblRollNo.setFont(commonFont);
		contentPane.add(lblRollNo);
		
		textRollNo = new JTextField();
		textRollNo.setFont(commonFont);
		contentPane.add(textRollNo);
		textRollNo.setColumns(10);
		
		// ---- Name Section ----
		JLabel lblName = new JLabel("Enter Name:");
		lblName.setFont(commonFont);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setFont(commonFont);
		contentPane.add(textName);
		textName.setColumns(10);
		
		// ---- Email Section ----
		JLabel lblEmail = new JLabel("Enter Email:");
		lblEmail.setFont(commonFont);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(commonFont);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		// ---- Insert Button ----
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(commonFont);
				btnInsert.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {

				        try {

				            int rno = Integer.parseInt(textRollNo.getText().trim());
				            String name = textName.getText().trim();
				            String email = textEmail.getText().trim();

				            Connection con = DriverManager.getConnection(
				                    "jdbc:mysql://localhost:3307/cscorner",
				                    "root",
				                    "!@#$%^&*()"
				            );

				            String query = "INSERT INTO student VALUES(?,?,?)";

				            PreparedStatement ps = con.prepareStatement(query);

				            ps.setInt(1, rno);
				            ps.setString(2, name);
				            ps.setString(3, email);

				            int result = ps.executeUpdate();

				            JOptionPane.showMessageDialog(StudentFrame.this,
				                    result + " Record Inserted Successfully!");

				            ps.close();
				            con.close();

				        }
				        catch (NumberFormatException ex) {

				            JOptionPane.showMessageDialog(StudentFrame.this,
				                    "Roll Number must be numeric.");

				        }
				        catch (Exception ex) {

				            ex.printStackTrace();

				            JOptionPane.showMessageDialog(StudentFrame.this,
				                    ex.getMessage());

				        }

				    }
				});
		contentPane.add(btnInsert);
		
		// ---- Reset Button ----
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(commonFont);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clears input text fields
				textRollNo.setText("");
				textName.setText("");
				textEmail.setText("");
			}
		});
		contentPane.add(btnReset);
	}
}
