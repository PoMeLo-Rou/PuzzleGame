//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.itheima.ui;

import com.itheima.domain.Data;
import com.itheima.domain.User;
import com.itheima.util.CodeUtil;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginJFrame extends JFrame implements MouseListener {
    ArrayList<Data> list = new ArrayList();
    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();
    JLabel rightCode = new JLabel();

    public LoginJFrame() throws IOException {
        this.data();
        this.initJFrame();
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

        br.close();
    }

    public void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);
        this.username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(this.username);
        JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);
        this.password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(this.password);
        JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);
        this.code.setBounds(195, 256, 100, 30);
        this.code.addMouseListener(this);
        this.getContentPane().add(this.code);
        String codeStr = CodeUtil.getCode();
        this.rightCode.setText(codeStr);
        this.rightCode.addMouseListener(this);
        this.rightCode.setBounds(300, 256, 50, 30);
        this.getContentPane().add(this.rightCode);
        this.login.setBounds(123, 310, 128, 47);
        this.login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        this.login.setBorderPainted(false);
        this.login.setContentAreaFilled(false);
        this.login.addMouseListener(this);
        this.getContentPane().add(this.login);
        this.register.setBounds(256, 310, 128, 47);
        this.register.setIcon(new ImageIcon("image\\register\\注册按钮.png"));
        this.register.setBorderPainted(false);
        this.register.setContentAreaFilled(false);
        this.register.addMouseListener(this);
        this.getContentPane().add(this.register);
        JLabel background = new JLabel(new ImageIcon("image\\register\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    public void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("Java周五下午一二节第20组 登录");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setAlwaysOnTop(true);
        this.setLayout((LayoutManager)null);
    }

    public void mouseClicked(MouseEvent e) {
        String code;
        if (e.getSource() == this.login) {
            System.out.println("点击了登录按钮");
            code = this.username.getText();
            String passwordInput = this.password.getText();
            String codeInput = this.code.getText();
            User userInfo = new User(code, passwordInput);
            System.out.println("用户输入的用户名为" + code);
            System.out.println("用户输入的密码为" + passwordInput);
            if (codeInput.length() == 0) {
                this.showJDialog("验证码不能为空");
                code = CodeUtil.getCode();
                this.rightCode.setText(code);
            } else if (code.length() != 0 && passwordInput.length() != 0) {
                if (!codeInput.equalsIgnoreCase(this.rightCode.getText())) {
                    this.showJDialog("验证码输入错误");
                    this.code.setText("");
                    code = CodeUtil.getCode();
                    this.rightCode.setText(code);
                } else if (this.contains(userInfo, this.list)) {
                    System.out.println("用户名和密码正确可以开始玩游戏了");
                    new GameJFrame();
                    this.setVisible(false);
                } else {
                    System.out.println("用户名或密码错误");
                    this.showJDialog("用户名或密码错误");
                    this.password.setText("");
                    this.code.setText("");
                    code = CodeUtil.getCode();
                    this.rightCode.setText(code);
                }
            } else {
                System.out.println("用户名或者密码为空");
                this.showJDialog("用户名或者密码为空");
                this.code.setText("");
                code = CodeUtil.getCode();
                this.rightCode.setText(code);
            }
        } else if (e.getSource() == this.register) {
            System.out.println("点击了注册按钮");

            try {
                new RegisterJFrame();
                this.setVisible(false);
            } catch (IOException var7) {
                IOException ex = var7;
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == this.rightCode) {
            System.out.println("更换验证码");
            code = CodeUtil.getCode();
            this.rightCode.setText(code);
        }

    }

    public void showJDialog(String content) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo((Component)null);
        jDialog.setModal(true);
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);
        jDialog.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.login) {
            this.login.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        } else if (e.getSource() == this.register) {
            this.register.setIcon(new ImageIcon("image\\register\\注册按下.png"));
        }

    }

    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.login) {
            this.login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        } else if (e.getSource() == this.register) {
            this.register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
            this.register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
        }

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public boolean contains(User userInput, ArrayList<Data> data) {
        for(int i = 0; i < data.size(); ++i) {
            Data rightUser = (Data)data.get(i);
            if (userInput.getUsername().equals(rightUser.getName()) && userInput.getPassword().equals(rightUser.getPassword())) {
                return true;
            }
        }

        return false;
    }
}
