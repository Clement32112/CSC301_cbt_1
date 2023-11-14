/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cbt_trial;

import java.awt.Button;
import java.awt.Color;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class cbt_visuals extends javax.swing.JFrame {

    public class count_down_thread extends Thread {

        JLabel label = timer;
        Duration current_time = Duration.ZERO;
        boolean should_end = true;

        public count_down_thread(int hrs, int min, int sec) {
            current_time = Duration.ofSeconds(sec + 60 * min + 60 * 60 * hrs);

        }

        public void run() {

            while (should_end) {
                try {
                    if (current_time.isPositive() && !current_time.isZero()) {
                        current_time = current_time.minus(Duration.ofSeconds(1));
                        sleep(Duration.ofSeconds(1));

                    } else {
                        should_end = true;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }

                {

                    if (label.isValid()) {
                        int hrs = current_time.toHoursPart();
                        int min = current_time.toMinutesPart();
                        int sec = current_time.toSecondsPart();
                        String txt_time = String.valueOf(hrs) + ":" + String.valueOf(min) + " : " + String.valueOf(sec);
                        label.setText(txt_time);
                    }

                }
            }

        }
    }

    public class blink_thread extends Thread {

        public blink_thread() {
        }

        public void run() {
            while (true) {

                change_color(Color.red);
                //change_color(Color.blue);
                //change_color(Color.cyan);
                //change_color(Color.orange);
                change_color(Color.black);
            }
        }

        void change_color(java.awt.Color color) {
            try {
                timer.setForeground(color);
                sleep(Duration.ofMillis(500));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }

        }
    }
    count_down_thread count_down;
    blink_thread blinker;

    int current_question = 0;
    String[] questions = {
        "What is the first syntax printed to the console in every programming language?",
        "2+5",
        "120 - 71"
    };
    String[][] options = {
        {"It's coding time", "Let's get rusty", "Hello world!", "helloWorld"},
        {"23", "10", "7", "4"},
        {"12", "49", "21", "39"},};

    String[] correct_answer = {"Hello world!", "7", "49",};
    String[] user_answers = {"", "", "", ""};
    public javax.swing.JRadioButton[] options_btns;

    public cbt_visuals() {
        initComponents();
        options_btns = new javax.swing.JRadioButton[]{option1, option2, option3, option4};
        set_question(current_question);
        count_down = new count_down_thread(0, 1, 0);
        blinker = new blink_thread();
        count_down.start();
        blinker.start();

    }

    private void set_options(int question_no) {
        option1.setText(options[question_no][0]);
        option2.setText(options[question_no][1]);
        option3.setText(options[question_no][2]);
        option4.setText(options[question_no][3]);
    }

    private void set_question(int question_no) {
        answers.clearSelection();
        question_area.setText(questions[question_no]);
        set_options(question_no);
        load_answer();
    }

    private int get_score() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (user_answers[i] == correct_answer[i]) {
                score++;
            }
        }
        return score;
    }

    private void display_score() {
        String final_score = "You got " + String.valueOf(get_score()) + " /" + String.valueOf(questions.length);
        JOptionPane.showMessageDialog(rootPane, final_score);
    }

    /**
     * Creates new form cbt_visuals
     */
    void load_answer() {
        for (javax.swing.JRadioButton opt : options_btns) {
            if (user_answers[current_question] == opt.getText()) {
                opt.setSelected(true);
                return;

            }
        }

    }
// Gets the option value and adds it t

    void capture_answer() {
        for (javax.swing.JRadioButton opt : options_btns) {
            if (opt.isSelected()) {
                System.out.println(opt.getText());
                user_answers[current_question] = opt.getText();
                return;//opt.getText();
            }
        }
        /*        {
            System.out.print(((javax.swing.JRadioButton) (answers.getSelection())).getText());
        }
        ;*/

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answers = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        question_area = new javax.swing.JTextArea();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        next_btn = new javax.swing.JButton();
        prev_btn = new javax.swing.JButton();
        submit_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        timer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("Computer Based Test");

        question_area.setEditable(false);
        question_area.setColumns(20);
        question_area.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        question_area.setLineWrap(true);
        question_area.setRows(5);
        question_area.setText("This is a question area");
        question_area.setWrapStyleWord(true);
        jScrollPane1.setViewportView(question_area);

        answers.add(option1);
        option1.setText("option1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        answers.add(option2);
        option2.setText("option2");

        answers.add(option3);
        option3.setText("option3");

        answers.add(option4);
        option4.setText("option4");

        next_btn.setText("Next");
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });

        prev_btn.setText("Prev");
        prev_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev_btnActionPerformed(evt);
            }
        });

        submit_btn.setText("Submit");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });

        jButton1.setText("Calculator");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        timer.setText("timer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(prev_btn)
                .addGap(58, 58, 58)
                .addComponent(next_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(submit_btn)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(option1)
                    .addComponent(option3)
                    .addComponent(option4)
                    .addComponent(option2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timer, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prev_btn)
                    .addComponent(submit_btn)
                    .addComponent(next_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option1ActionPerformed

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed
        capture_answer();
        if (current_question < questions.length - 1) {
            current_question++;
        } else {
            JOptionPane.showMessageDialog(rootPane, "This is the last question");
        }
        set_question(current_question);

    }//GEN-LAST:event_next_btnActionPerformed

    private void prev_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev_btnActionPerformed
        capture_answer();
        if (current_question > 0) {
            current_question--;
        } else {
            JOptionPane.showMessageDialog(rootPane, "This is the first question");
        }
        set_question(current_question);

    }//GEN-LAST:event_prev_btnActionPerformed

    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed
        // TODO add your handling code here:

        capture_answer();

        int value = JOptionPane.showConfirmDialog(rootPane, "Are You sure you want submit");
        switch (value) {
            case 0:
                //Yes pls submit
                prev_btn.enableInputMethods(false);
                next_btn.enableInputMethods(false);
                count_down.stop();
                display_score();

                break;
            case 1://no don't submit

                break;
            case 2:
                //cancel
                break;
            default:
                throw new AssertionError();
        }
        //next_bt
    }//GEN-LAST:event_submit_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Help");
        try {
            Runtime.getRuntime().exec("kcalc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(cbt_visuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cbt_visuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cbt_visuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cbt_visuals.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cbt_visuals().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup answers;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next_btn;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JButton prev_btn;
    private javax.swing.JTextArea question_area;
    private javax.swing.JButton submit_btn;
    private javax.swing.JLabel timer;
    // End of variables declaration//GEN-END:variables
}
