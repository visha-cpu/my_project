package com.hospital.main;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.PatientDAO;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class HospitalSwingApp extends JFrame {

    private final DoctorDAO doctorDAO = new DoctorDAO();
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private final PatientDAO patientDAO = new PatientDAO();

    private DefaultTableModel doctorTableModel;
    private DefaultTableModel appointmentTableModel;
    private DefaultTableModel patientTableModel;

    private JTextField apptPatientIdField;
    private JTextField apptDoctorIdField;
    private JTextField apptDateField;

    private JTextField patientNameField;
    private JTextField patientAgeField;
    private JComboBox<String> patientGenderCombo;

    // --- Dark Theme Professional Color Palette ---
    private static final Color DARK_BG = new Color(24, 28, 36);          // Main Window Background
    private static final Color CARD_BG = new Color(33, 38, 49);          // Panel/Card Background
    private static final Color ACCENT_BLUE = new Color(53, 132, 228);     // Buttons & Highlights
    private static final Color ACCENT_HOVER = new Color(30, 102, 192);    // Button Hover State
    private static final Color TEXT_PRIMARY = new Color(240, 243, 246);   // Main Text Color
    private static final Color TEXT_MUTED = new Color(160, 172, 186);     // Secondary Text
    private static final Color INPUT_BG = new Color(44, 51, 64);         // Input Fields Background
    private static final Color BORDER_COLOR = new Color(58, 66, 82);      // Subtle Borders

    public HospitalSwingApp() {
        setTitle("Hospital Management System - Dashboard");
        setSize(950, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(DARK_BG);

        // Custom Styled Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(CARD_BG);
        tabbedPane.setForeground(TEXT_PRIMARY);
        tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 13));

        tabbedPane.addTab("Patients Directory", createPatientPanel());
        tabbedPane.addTab("Doctors Directory", createDoctorPanel());
        tabbedPane.addTab("Book Appointment", createBookingPanel());
        tabbedPane.addTab("View Appointments", createAppointmentPanel());

        add(tabbedPane);

        refreshPatientTable();
        refreshDoctorTable();
        refreshAppointmentTable();
    }

    private JPanel createPatientPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(DARK_BG);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(CARD_BG);
        
        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1), 
                "Register New Patient", 
                TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("SansSerif", Font.BOLD, 14), TEXT_PRIMARY
        );
        formPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        patientNameField = createStyledTextField(15);
        patientAgeField = createStyledTextField(5);
        patientGenderCombo = createStyledComboBox(new String[]{"Male", "Female", "Other"});
        JButton registerButton = createStyledButton("Register Patient");

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(createStyledLabel("Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(patientNameField, gbc);

        gbc.gridx = 2;
        formPanel.add(createStyledLabel("Age:"), gbc);
        gbc.gridx = 3;
        formPanel.add(patientAgeField, gbc);

        gbc.gridx = 4;
        formPanel.add(createStyledLabel("Gender:"), gbc);
        gbc.gridx = 5;
        formPanel.add(patientGenderCombo, gbc);

        gbc.gridx = 6;
        formPanel.add(registerButton, gbc);

        registerButton.addActionListener(e -> handlePatientRegistration());

        // Table
        String[] columns = {"Patient ID", "Name", "Age", "Gender"};
        patientTableModel = new DefaultTableModel(columns, 0);
        JTable patientTable = createStyledTable(patientTableModel);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(createStyledScrollPane(patientTable), BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createDoctorPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(DARK_BG);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel header = new JLabel("Available Doctors Directory", SwingConstants.LEFT);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        header.setForeground(TEXT_PRIMARY);

        String[] columns = {"Doctor ID", "Name", "Specialization"};
        doctorTableModel = new DefaultTableModel(columns, 0);
        JTable doctorTable = createStyledTable(doctorTableModel);

        panel.add(header, BorderLayout.NORTH);
        panel.add(createStyledScrollPane(doctorTable), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createBookingPanel() {
        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(DARK_BG);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(CARD_BG);
        
        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1), 
                "Schedule Appointment", 
                TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("SansSerif", Font.BOLD, 15), TEXT_PRIMARY
        );
        mainPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        apptPatientIdField = createStyledTextField(15);
        apptDoctorIdField = createStyledTextField(15);
        apptDateField = createStyledTextField(15);
        JButton bookButton = createStyledButton("Confirm Booking");

        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(createStyledLabel("Patient ID:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(apptPatientIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(createStyledLabel("Doctor ID:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(apptDoctorIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(createStyledLabel("Date (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        mainPanel.add(apptDateField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        mainPanel.add(bookButton, gbc);

        bookButton.addActionListener(e -> handleBooking());

        container.add(mainPanel);
        return container;
    }

    private JPanel createAppointmentPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(DARK_BG);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel header = new JLabel("Scheduled Appointments List", SwingConstants.LEFT);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        header.setForeground(TEXT_PRIMARY);

        String[] columns = {"Appt ID", "Patient ID", "Doctor ID", "Date"};
        appointmentTableModel = new DefaultTableModel(columns, 0);
        JTable appointmentTable = createStyledTable(appointmentTableModel);

        panel.add(header, BorderLayout.NORTH);
        panel.add(createStyledScrollPane(appointmentTable), BorderLayout.CENTER);

        return panel;
    }

    // --- UI Component Custom Styling Factory Methods ---

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(TEXT_MUTED);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        return label;
    }

    private JTextField createStyledTextField(int columns) {
        JTextField tf = new JTextField(columns);
        tf.setBackground(INPUT_BG);
        tf.setForeground(TEXT_PRIMARY);
        tf.setCaretColor(TEXT_PRIMARY);
        tf.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
        return tf;
    }

    private JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setBackground(INPUT_BG);
        combo.setForeground(TEXT_PRIMARY);
        combo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        return combo;
    }

    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(ACCENT_BLUE);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));

        // Hover Effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(ACCENT_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(ACCENT_BLUE);
            }
        });
        return btn;
    }

    private JTable createStyledTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setBackground(CARD_BG);
        table.setForeground(TEXT_PRIMARY);
        table.setGridColor(BORDER_COLOR);
        table.setRowHeight(30);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.setSelectionBackground(ACCENT_BLUE);
        table.setSelectionForeground(Color.WHITE);

        // Header Styling
        JTableHeader header = table.getTableHeader();
        header.setBackground(INPUT_BG);
        header.setForeground(TEXT_PRIMARY);
        header.setFont(new Font("SansSerif", Font.BOLD, 13));
        header.setReorderingAllowed(false);

        // Center Cell Text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setBackground(CARD_BG);
        centerRenderer.setForeground(TEXT_PRIMARY);
        table.setDefaultRenderer(Object.class, centerRenderer);

        return table;
    }

    private JScrollPane createStyledScrollPane(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(CARD_BG);
        scrollPane.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        return scrollPane;
    }

    // --- Action Handlers ---

    private void handlePatientRegistration() {
        try {
            String name = patientNameField.getText().trim();
            String ageText = patientAgeField.getText().trim();
            String gender = (String) patientGenderCombo.getSelectedItem();

            if (name.isEmpty() || ageText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age = Integer.parseInt(ageText);
            patientDAO.addPatient(name, age, gender);

            JOptionPane.showMessageDialog(this, "Patient Registered Successfully!");
            patientNameField.setText("");
            patientAgeField.setText("");

            refreshPatientTable();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleBooking() {
        try {
            int patientId = Integer.parseInt(apptPatientIdField.getText().trim());
            int doctorId = Integer.parseInt(apptDoctorIdField.getText().trim());
            String date = apptDateField.getText().trim();

            if (date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Doctor doctor = doctorDAO.getDoctorById(doctorId);
            if (doctor == null) {
                JOptionPane.showMessageDialog(this, "Doctor ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (appointmentDAO.isDoctorAvailable(doctorId, date)) {
                appointmentDAO.bookAppointment(patientId, doctorId, date);
                JOptionPane.showMessageDialog(this, "Appointment confirmed with " + doctor.getName());
                apptPatientIdField.setText("");
                apptDoctorIdField.setText("");
                apptDateField.setText("");
                refreshAppointmentTable();
            } else {
                JOptionPane.showMessageDialog(this, doctor.getName() + " is unavailable on " + date, "Booking Failed", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Patient ID and Doctor ID must be integers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshPatientTable() {
        patientTableModel.setRowCount(0);
        for (Patient p : patientDAO.getAllPatients()) {
            patientTableModel.addRow(new Object[]{p.getId(), p.getName(), p.getAge(), p.getGender()});
        }
    }

    private void refreshDoctorTable() {
        doctorTableModel.setRowCount(0);
        for (Doctor doc : doctorDAO.getAllDoctors()) {
            doctorTableModel.addRow(new Object[]{doc.getId(), doc.getName(), doc.getSpecialization()});
        }
    }

    private void refreshAppointmentTable() {
        appointmentTableModel.setRowCount(0);
        for (Appointment app : appointmentDAO.getAllAppointments()) {
            appointmentTableModel.addRow(new Object[]{
                    app.getAppointmentId(),
                    app.getPatientId(),
                    app.getDoctorId(),
                    app.getAppointmentDate()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalSwingApp().setVisible(true));
    }
}