//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.itheima.ui;

import com.itheima.domain.Data;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterJFrame extends JFrame implements MouseListener {
    ArrayList<Data> list = new ArrayList();
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField rePassword = new JTextField();
    JButton submit = new JButton();
    JButton reset = new JButton();
    JDialog jDialog = new JDialog();

    public RegisterJFrame() throws IOException {
        this.data();
        this.initFrame();
        this.initView();
        this.setVisible(true);
    }

    public void data() throws IOException {
        File file = new File("data.txt");
        file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));

        String str;
        while((str = br.readLine()) != null) {
            String[] data = str.split("&");
            String name = data[0].split("=")[1];
            String password = data[1].split("=")[1];
            this.list.add(new Data(name, password));
        }

    }

    public void mouseClicked(MouseEvent e) {
        String userNameStr = this.username.getText();
        String passWordStr = this.password.getText();
        String rePasswordText = this.rePassword.getText();
        if (e.getSource() == this.submit) {
            System.out.println("注册");
            if (userNameStr.length() != 0 && passWordStr.length() != 0 && rePasswordText.length() != 0) {
                if (!passWordStr.equals(rePasswordText)) {
                    this.showDialog("密码不一致");
                    this.rePassword.setText("");
                } else if (!this.tfUsername(userNameStr)) {
                    this.showDialog("账号已存在");
                } else {
                    try {
                        this.Data(userNameStr, passWordStr);
                        this.showDialog("注册成功");
                        this.setVisible(false);
                        new LoginJFrame();
                    } catch (IOException var6) {
                        IOException ex = var6;
                        throw new RuntimeException(ex);
                    }
                }
            } else {
                this.showDialog("账号或密码不能为空");
                this.password.setText("");
                this.rePassword.setText("");
            }
        } else if (e.getSource() == this.reset) {
            System.out.println("重置");
            this.password.setText("");
            this.rePassword.setText("");
            this.username.setText("");
        }

    }

    private void Data(String name, String password) throws IOException {
        String data = "name=" + name + "&password=" + password;
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt", true));
        bw.write(data);
        bw.newLine();
        bw.close();
    }

    private boolean tfUsername(String userName) {
        Iterator var2 = this.list.iterator();

        Data data;
        do {
            if (!var2.hasNext()) {
                return true;
            }

            data = (Data)var2.next();
        } while(!data.getName().equals(userName));

        return false;
    }

    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.submit) {
            this.submit.setIcon(new ImageIcon("image\\register\\注册按下.png"));
        } else if (e.getSource() == this.reset) {
            this.reset.setIcon(new ImageIcon("image\\register\\重置按下.png"));
        }

    }

    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.submit) {
            this.submit.setIcon(new ImageIcon("image\\register\\注册按钮.png"));
        } else if (e.getSource() == this.reset) {
            this.reset.setIcon(new ImageIcon("image\\register\\重置按钮.png"));
        }

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    private void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("image\\register\\注册用户名.png"));
        usernameText.setBounds(85, 135, 80, 20);
        this.username.setBounds(195, 134, 200, 30);
        JLabel passwordText = new JLabel(new ImageIcon("image\\register\\注册密码.png"));
        passwordText.setBounds(97, 193, 70, 20);
        this.password.setBounds(195, 195, 200, 30);
        JLabel rePasswordText = new JLabel(new ImageIcon("image\\register\\再次输入密码.png"));
        rePasswordText.setBounds(64, 255, 95, 20);
        this.rePassword.setBounds(195, 255, 200, 30);
        this.submit.setIcon(new ImageIcon("image\\register\\注册按钮.png"));
        this.submit.setBounds(123, 310, 128, 47);
        this.submit.setBorderPainted(false);
        this.submit.setContentAreaFilled(false);
        this.submit.addMouseListener(this);
        this.reset.setIcon(new ImageIcon("image\\register\\重置按钮.png"));
        this.reset.setBounds(256, 310, 128, 47);
        this.reset.setBorderPainted(false);
        this.reset.setContentAreaFilled(false);
        this.reset.addMouseListener(this);
        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(usernameText);
        this.getContentPane().add(passwordText);
        this.getContentPane().add(rePasswordText);
        this.getContentPane().add(this.username);
        this.getContentPane().add(this.password);
        this.getContentPane().add(this.rePassword);
        this.getContentPane().add(this.submit);
        this.getContentPane().add(this.reset);
        this.getContentPane().add(background);
    }

    private void initFrame() {
        this.setSize(488, 430);
        this.setTitle("Java周五下午一二节第20组 注册");
        this.setLayout((LayoutManager)null);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setAlwaysOnTop(true);
    }

    public void showDialog(String content) {
        if (!this.jDialog.isVisible()) {
            this.jDialog.getContentPane().removeAll();
            JLabel jLabel = new JLabel(content);
            jLabel.setBounds(0, 0, 200, 150);
            this.jDialog.add(jLabel);
            this.jDialog.setSize(200, 150);
            this.jDialog.setAlwaysOnTop(true);
            this.jDialog.setLocationRelativeTo((Component)null);
            this.jDialog.setModal(true);
            this.jDialog.setVisible(true);
        }

    }
}
