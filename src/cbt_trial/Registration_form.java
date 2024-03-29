package cbt_trial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author shadownight32112
 */
public class Registration_form extends javax.swing.JFrame {

    /**
     * Creates new form Registration_form
     */
    public Registration_form() {
        initComponents();
        on_start();

    }

    void add_entry() {
        try {
            System.out.println("Starting addition");
            String matno = Mat_no.getText();
            String first_name = Firstname_field.getText();
            String surname = Surname_field.getText();
            String othername = Othername_field.getText();
            String gender = "null";
            if (Male_btn.isSelected()) {
                gender = "Male";
            } else if (Female_btn.isSelected()) {
                gender = "Female";
            }

            String department = Department_box.getSelectedItem().toString();
            String level = Level_box.getSelectedItem().toString();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_register", "root", "password");
            PreparedStatement ps = con.prepareStatement("insert into students values(?,?,?,?,?,?,?)");
            System.out.println("done Updateing");
            ps.setString(1, matno);

            ps.setString(2, surname);
            ps.setString(3, first_name);
            ps.setString(4, othername);
            ps.setString(5, gender);
            ps.setString(6, department);
            ps.setString(7, level);

            int rs = ps.executeUpdate();

            System.out.println("Execute Value " + String.valueOf(rs));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    void on_start() {
        clear_tab_1();
        clear_tab_2();
    }

    void clear_tab_1() {
        Firstname_field.setText("");
        Surname_field.setText("");
        Othername_field.setText("");
        Male_btn.setSelected(false);
        Female_btn.setSelected(false);
        Department_box.setSelectedIndex(0);
        Level_box.setSelectedIndex(0);
        Mat_no.setText("");
    }

    void clear_tab_2() {
        Firstname_field1.setText("");
        Surname_field1.setText("");
        Othername_field1.setText("");
        Male_btn1.setSelected(false);
        Female_btn1.setSelected(false);
        Department_box1.setSelectedIndex(0);
        Level_box1.setSelectedIndex(0);
        Mat_no1.setText("");

    }

    void update() {
        try {
            System.out.println("Update starting");
            System.out.println("Starting database update");
            String matno = Mat_no1.getText();
            String first_name = Firstname_field1.getText();
            String surname = Surname_field1.getText();
            String othername = Othername_field1.getText();
            String gender = "null";
            if (Male_btn1.isSelected()) {
                gender = "Male";
            } else if (Female_btn1.isSelected()) {
                gender = "Female";
            }

            String department = Department_box1.getSelectedItem().toString();
            String level = Level_box1.getSelectedItem().toString();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_register", "root", "password");
            PreparedStatement ps = con.prepareStatement("update students set surname=?, firstname=?, othername=?, gender=?, department=?,level=? where matno = ?");
            System.out.println("Starting update");

            ps.setString(1, surname);
            ps.setString(2, first_name);
            ps.setString(3, othername);
            ps.setString(4, gender);
            ps.setString(5, department);
            ps.setString(6, level);
            ps.setString(7, matno);
            int rs = ps.executeUpdate();

            System.out.println("Execute Value " + String.valueOf(rs));

            System.out.println("Update done");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    void search() {

        try {

            System.out.println("Stating up");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_register", "root", "password");
            PreparedStatement ps = con.prepareStatement("select * from students where matno=?");
            System.out.println("Starting search");
            ps.setString(1, Mat_no1.getText());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Surname_field1.setText(rs.getString(2));
                Firstname_field1.setText(rs.getString(3));
                Othername_field1.setText(rs.getString(4));
                String gender = rs.getString(5);
                if (gender.equalsIgnoreCase("Male")) {
                    Male_btn1.setSelected(true);
                } else {
                    Female_btn1.setSelected(true);
                }

                Department_box1.setSelectedItem(rs.getString(6));
                Level_box1.setSelectedItem(rs.getString(7));
                System.out.println("Done searching");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
    }

    void delete() {
        try {
            System.out.println("Deleting up");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_register", "root", "password");
            PreparedStatement ps = con.prepareStatement("delete from students where matno=?");
            System.out.println("Starting Deleting");
            ps.setString(1, Mat_no1.getText());
            ps.executeUpdate();
            System.out.println("done deleting");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    void create_user() {

        String username = username_field_sec.getText();
        String password = passwed_field_sec.getText();
        String password_repeat = password_field_sec_repeat.getText();

        if (!password.equals(password_repeat)) {
            JOptionPane.showMessageDialog(rootPane, "Password does not match");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_register", "root", "password");
            PreparedStatement ps = con.prepareStatement("insert into login values(?,?)");
            System.out.println("done Updateing");

            ps.setString(1, username);
            ps.setString(2, passwed_field_sec.getPassword().toString());
            ps.executeUpdate();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Registration_btngroup = new javax.swing.ButtonGroup();
        SUD_btngroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        insert_tab_1_btn = new javax.swing.JButton();
        clear_tab_1_btn = new javax.swing.JButton();
        Surname_field = new javax.swing.JTextField();
        Firstname_field = new javax.swing.JTextField();
        Othername_field = new javax.swing.JTextField();
        Male_btn = new javax.swing.JRadioButton();
        Female_btn = new javax.swing.JRadioButton();
        Department_box = new javax.swing.JComboBox<>();
        Level_box = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Mat_no = new javax.swing.JTextField();
        Date1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        password_field_sec_repeat = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        passwed_field_sec = new javax.swing.JPasswordField();
        username_field_sec = new javax.swing.JTextField();
        create_user_btn = new javax.swing.JButton();
        clear_btn_2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        update_btn = new javax.swing.JButton();
        Delete_btn = new javax.swing.JButton();
        Surname_field1 = new javax.swing.JTextField();
        Firstname_field1 = new javax.swing.JTextField();
        Othername_field1 = new javax.swing.JTextField();
        Male_btn1 = new javax.swing.JRadioButton();
        Female_btn1 = new javax.swing.JRadioButton();
        Department_box1 = new javax.swing.JComboBox<>();
        Level_box1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        Mat_no1 = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        Date2 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Surname");

        jLabel3.setText("Gender");

        jLabel4.setText("DOB");

        jLabel5.setText("Firstname");

        jLabel6.setText("Department");

        jLabel7.setText("Level");

        insert_tab_1_btn.setText("Insert");
        insert_tab_1_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_tab_1_btnActionPerformed(evt);
            }
        });

        clear_tab_1_btn.setText("Clear");
        clear_tab_1_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_tab_1_btnActionPerformed(evt);
            }
        });

        Surname_field.setText("jTextField1");

        Firstname_field.setText("jTextField2");

        Othername_field.setText("jTextField3");

        Registration_btngroup.add(Male_btn);
        Male_btn.setText("Male");

        Registration_btngroup.add(Female_btn);
        Female_btn.setText("Female");

        Department_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Computer Science", "Data Science", "Electrical Engineering", "Mechnaical Engineering" }));

        Level_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Level", "100 lvl", "200 lvl", "300 lvl", "400 lvl", "500 lvl" }));

        jLabel8.setText("MatNo");

        Mat_no.setText("jTextField1");

        jLabel19.setText("Othernames");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(insert_tab_1_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear_tab_1_btn)
                .addGap(45, 45, 45))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Firstname_field, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(Othername_field)
                                .addComponent(Surname_field))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(40, 40, 40)
                            .addComponent(Male_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Female_btn))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Department_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Level_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Mat_no, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Surname_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Firstname_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19))
                    .addComponent(Othername_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Male_btn)
                    .addComponent(Female_btn))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Department_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Level_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Mat_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clear_tab_1_btn)
                    .addComponent(insert_tab_1_btn))
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Register", jPanel2);

        jLabel16.setText("Username");

        jLabel17.setText("Password");

        jLabel18.setText("Repeat Password");

        username_field_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_field_secActionPerformed(evt);
            }
        });

        create_user_btn.setText("Create User");
        create_user_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_user_btnActionPerformed(evt);
            }
        });

        clear_btn_2.setText("Clear");
        clear_btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btn_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwed_field_sec, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(username_field_sec)
                    .addComponent(password_field_sec_repeat))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(create_user_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear_btn_2)
                .addGap(64, 64, 64))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(username_field_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(passwed_field_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_field_sec_repeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_user_btn)
                    .addComponent(clear_btn_2))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Security", jPanel4);

        jLabel9.setText("Surname");

        jLabel10.setText("Gender");

        jLabel11.setText("Othernames");

        jLabel12.setText("Firstname");

        jLabel13.setText("Department");

        jLabel14.setText("Level");

        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        Delete_btn.setText("Delete");
        Delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_btnActionPerformed(evt);
            }
        });

        Surname_field1.setText("jTextField1");

        Firstname_field1.setText("jTextField2");

        Othername_field1.setText("jTextField3");

        SUD_btngroup.add(Male_btn1);
        Male_btn1.setText("Male");

        SUD_btngroup.add(Female_btn1);
        Female_btn1.setText("Female");

        Department_box1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Computer Science", "Data Science", "Electrical Engineering", "Mechnaical Engineering" }));

        Level_box1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Level", "100 lvl", "200 lvl", "300 lvl", "400 lvl", "500 lvl" }));

        jLabel15.setText("MatNo");

        Mat_no1.setText("jTextField1");

        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        jLabel20.setText("DOB");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel20))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(Mat_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(search_btn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Othername_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(update_btn))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel10)))
                                        .addGap(31, 31, 31))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(14, 14, 14)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Delete_btn)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(Male_btn1)
                                            .addGap(18, 18, 18)
                                            .addComponent(Female_btn1))
                                        .addComponent(Department_box1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Level_box1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Firstname_field1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(Surname_field1))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Mat_no1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Surname_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Firstname_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Othername_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Male_btn1)
                        .addComponent(Female_btn1))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Department_box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(Level_box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_btn)
                    .addComponent(Delete_btn))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Select/Update/Delete", jPanel3);

        jLabel1.setText("Registration");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clear_tab_1_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_tab_1_btnActionPerformed
        clear_tab_1();

    }//GEN-LAST:event_clear_tab_1_btnActionPerformed

    private void insert_tab_1_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_tab_1_btnActionPerformed
        add_entry();
    }//GEN-LAST:event_insert_tab_1_btnActionPerformed

    private void username_field_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_field_secActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_field_secActionPerformed

    private void clear_btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btn_2ActionPerformed
        username_field_sec.setText("");
        passwed_field_sec.setText("");
        password_field_sec_repeat.setText("");
    }//GEN-LAST:event_clear_btn_2ActionPerformed

    private void create_user_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_user_btnActionPerformed
        // TODO add your handling code here:
        create_user();
        //int rs = ps.executeUpdate();

    }//GEN-LAST:event_create_user_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        search();
    }//GEN-LAST:event_search_btnActionPerformed

    private void Delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_btnActionPerformed
        delete();
        clear_tab_2();
    }//GEN-LAST:event_Delete_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        update();        // TODO add your handling code here:
    }//GEN-LAST:event_update_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registration_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date1;
    private com.toedter.calendar.JDateChooser Date2;
    private javax.swing.JButton Delete_btn;
    private javax.swing.JComboBox<String> Department_box;
    private javax.swing.JComboBox<String> Department_box1;
    private javax.swing.JRadioButton Female_btn;
    private javax.swing.JRadioButton Female_btn1;
    private javax.swing.JTextField Firstname_field;
    private javax.swing.JTextField Firstname_field1;
    private javax.swing.JComboBox<String> Level_box;
    private javax.swing.JComboBox<String> Level_box1;
    private javax.swing.JRadioButton Male_btn;
    private javax.swing.JRadioButton Male_btn1;
    private javax.swing.JTextField Mat_no;
    private javax.swing.JTextField Mat_no1;
    private javax.swing.JTextField Othername_field;
    private javax.swing.JTextField Othername_field1;
    private javax.swing.ButtonGroup Registration_btngroup;
    private javax.swing.ButtonGroup SUD_btngroup;
    private javax.swing.JTextField Surname_field;
    private javax.swing.JTextField Surname_field1;
    private javax.swing.JButton clear_btn_2;
    private javax.swing.JButton clear_tab_1_btn;
    private javax.swing.JButton create_user_btn;
    private javax.swing.JButton insert_tab_1_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField passwed_field_sec;
    private javax.swing.JPasswordField password_field_sec_repeat;
    private javax.swing.JButton search_btn;
    private javax.swing.JButton update_btn;
    private javax.swing.JTextField username_field_sec;
    // End of variables declaration//GEN-END:variables
}
