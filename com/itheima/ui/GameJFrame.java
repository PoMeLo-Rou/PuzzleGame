//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.itheima.ui;

import com.itheima.domain.GameInfo;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    JMenuItem du1;
    JMenuItem du2;
    JMenuItem du3;
    JMenuItem du4;
    JMenuItem du0;
    JMenuItem cun1;
    JMenuItem cun2;
    JMenuItem cun3;
    JMenuItem cun4;
    JMenuItem cun0;
    JMenu cunDang;
    JMenu duDang;
    int[][] data = new int[4][4];
    int x = 0;
    int y = 0;
    String path = "image\\animal\\animal3\\";
    int[][] win = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    int step = 0;
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem helpItem = new JMenuItem("帮助"); // 帮助菜单项
    Random r = new Random();

    public GameJFrame() {
        this.initJFrame();
        this.initJMenuBar();
        this.initData();
        this.initImage();
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();

        int i;
        for(i = 0; i < tempArr.length; ++i) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for(i = 0; i < tempArr.length; ++i) {
            if (tempArr[i] == 0) {
                this.x = i / 4;
                this.y = i % 4;
            }

            this.data[i / 4][i % 4] = tempArr[i];
        }

    }

    private void initImage() {
        this.getContentPane().removeAll();
        JLabel stepCount;
        if (this.victory()) {
            stepCount = new JLabel(new ImageIcon("image\\win.png"));
            stepCount.setBounds(203, 283, 197, 73);
            this.getContentPane().add(stepCount);
        }

        stepCount = new JLabel("步数：" + this.step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                int num = this.data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(this.path + num + ".jpg"));
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(1));
                this.getContentPane().add(jLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeImage = new JMenu("更换图片");
        this.cunDang = new JMenu("存档");
        this.duDang = new JMenu("读档");
        changeImage.add(this.girl);
        changeImage.add(this.animal);
        changeImage.add(this.sport);
        this.du0 = new JMenuItem("读档0（空）");
        this.du1 = new JMenuItem("读档1（空）");
        this.du2 = new JMenuItem("读档2（空）");
        this.du3 = new JMenuItem("读档3（空）");
        this.du4 = new JMenuItem("读档4（空）");
        this.cun0 = new JMenuItem("存档0（空）");
        this.cun1 = new JMenuItem("存档1（空）");
        this.cun2 = new JMenuItem("存档2（空）");
        this.cun3 = new JMenuItem("存档3（空）");
        this.cun4 = new JMenuItem("存档4（空）");
        this.cunDang.add(this.cun0);
        this.cunDang.add(this.cun1);
        this.cunDang.add(this.cun2);
        this.cunDang.add(this.cun3);
        this.cunDang.add(this.cun4);
        this.duDang.add(this.du0);
        this.duDang.add(this.du1);
        this.duDang.add(this.du2);
        this.duDang.add(this.du3);
        this.duDang.add(this.du4);
        functionJMenu.add(changeImage);
        functionJMenu.add(this.replayItem);
        functionJMenu.add(this.reLoginItem);
        functionJMenu.add(this.closeItem);
        functionJMenu.add(this.cunDang);
        functionJMenu.add(this.duDang);
        aboutJMenu.add(this.helpItem);
        this.girl.addActionListener(this);
        this.animal.addActionListener(this);
        this.sport.addActionListener(this);
        this.replayItem.addActionListener(this);
        this.reLoginItem.addActionListener(this);
        this.closeItem.addActionListener(this);
        this.helpItem.addActionListener(this);
        this.du0.addActionListener(this);
        this.du1.addActionListener(this);
        this.du2.addActionListener(this);
        this.du3.addActionListener(this);
        this.du4.addActionListener(this);
        this.cun0.addActionListener(this);
        this.cun1.addActionListener(this);
        this.cun2.addActionListener(this);
        this.cun3.addActionListener(this);
        this.cun4.addActionListener(this);
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        this.getGameInfo();
        this.setJMenuBar(jMenuBar);
    }

    private void getGameInfo() {
        File file = new File("save");
        File[] files = file.listFiles();
        if (files == null) {
            return; // 或者抛出一个特定的异常
        }

        for (File f : files) {
            GameInfo o = null;

            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                o = (GameInfo) ois.readObject();
                ois.close();
            } catch (IOException var11) {
                throw new RuntimeException(var11);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            // 对 GameInfo 对象执行操作
        }
    }


    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("Java周五下午一二节第20组");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setLayout((LayoutManager)null);
        this.addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(this.path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            JLabel background = new JLabel(new ImageIcon("image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }

    }

    public void keyReleased(KeyEvent e) {
        if (!this.victory()) {
            int code = e.getKeyCode();
            System.out.println(code);
            if (code == 37) {
                System.out.println("向左移动");
                if (this.y == 3) {
                    return;
                }

                this.data[this.x][this.y] = this.data[this.x][this.y + 1];
                this.data[this.x][this.y + 1] = 0;
                ++this.y;
                ++this.step;
                this.initImage();
            } else if (code == 38) {
                System.out.println("向上移动");
                if (this.x == 3) {
                    return;
                }

                this.data[this.x][this.y] = this.data[this.x + 1][this.y];
                this.data[this.x + 1][this.y] = 0;
                ++this.x;
                ++this.step;
                this.initImage();
            } else if (code == 39) {
                System.out.println("向右移动");
                if (this.y == 0) {
                    return;
                }

                this.data[this.x][this.y] = this.data[this.x][this.y - 1];
                this.data[this.x][this.y - 1] = 0;
                --this.y;
                ++this.step;
                this.initImage();
            } else if (code == 40) {
                System.out.println("向下移动");
                if (this.x == 0) {
                    return;
                }

                this.data[this.x][this.y] = this.data[this.x - 1][this.y];
                this.data[this.x - 1][this.y] = 0;
                --this.x;
                ++this.step;
                this.initImage();
            } else if (code == 65) {
                this.initImage();
            } else if (code == 87) {
                this.data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
                this.initImage();
            }

        }
    }

    public boolean victory() {
        for(int i = 0; i < this.data.length; ++i) {
            for(int j = 0; j < this.data[i].length; ++j) {
                if (this.data[i][j] != this.win[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == this.replayItem) {
            System.out.println("重新游戏");
            this.step = 0;
            this.initData();
            this.initImage();
        } else if (obj == this.reLoginItem) {
            System.out.println("重新登录");
            this.setVisible(false);

            try {
                new LoginJFrame();
            } catch (IOException var11) {
                IOException ex = var11;
                throw new RuntimeException(ex);
            }
        } else if (obj == this.closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (obj == this.helpItem) {


            System.out.println("帮助");
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel("游戏说明：按键盘上下左右移动，按住'a'可查看最终图片，\n" +
                    "按住w直接胜利。");
            jLabel.setBounds(0, 0, 300, 20);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(500, 200);// 设置弹框大小
            jDialog.setAlwaysOnTop(true);// 窗口置顶
            jDialog.setLocationRelativeTo(null);// 居中
            jDialog.setModal(true);// 弹框不关闭，则界面不可操控
            jDialog.setVisible(true);// 显示弹框



        } else {
            int number;
            if (obj == this.girl) {
                System.out.println("girl");
                number = this.r.nextInt(13) + 1;
                this.path = "image\\girl\\girl" + number + "\\";
                this.step = 0;
                this.initData();
                this.initImage();
            } else if (obj == this.animal) {
                System.out.println("animal");
                number = this.r.nextInt(8) + 1;
                this.path = "image\\animal\\animal" + number + "\\";
                this.step = 0;
                this.initData();
                this.initImage();
            } else if (obj == this.sport) {
                System.out.println("sport");
                number = this.r.nextInt(10) + 1;
                this.path = "image\\sport\\sport" + number + "\\";
                this.step = 0;
                this.initData();
                this.initImage();
            } else {
                JMenuItem item;
                int num;
                if (obj != this.du0 && obj != this.du2 && obj != this.du3 && obj != this.du4 && obj != this.du1) {
                    if (obj == this.cun1 || obj == this.cun2 || obj == this.cun3 || obj == this.cun4 || obj == this.cun0) {
                        System.out.println("存档");
                        item = (JMenuItem)obj;
                        num = Integer.parseInt(item.getText().substring(2, 3));

//                        try {
//                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save\\save" + num + ".data"));
//                            GameInfo gi = new GameInfo(this.data, this.x, this.y, this.path, this.step);
//                            oos.writeObject(gi);
//                            oos.close();
//                        } catch (IOException var7) {
//                            IOException ex = var7;
//                            throw new RuntimeException(ex);
//                        }

                        item.setText("存档" + num + "（" + this.step + "）步");
                        this.duDang.getItem(num).setText("读档" + num + "（" + this.step + "）步");
                    }
                } else {
                    System.out.println("读档");
                    item = (JMenuItem)obj;
                    num = Integer.parseInt(item.getText().substring(2, 3));
                    System.out.println(num);
                    GameInfo gi = null;

                    try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save\\save" + num + ".data"));
                        gi = (GameInfo)ois.readObject();
                        ois.close();
                    } catch (IOException var8) {
                        IOException ex = var8;
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException var9) {
                        ClassNotFoundException ex = var9;
                        throw new RuntimeException(ex);
                    }

                    this.data = gi.getData();
                    this.path = gi.getPath();
                    this.step = gi.getStep();
                    this.x = gi.getX();
                    this.y = gi.getY();
                    this.initImage();
                }
            }
        }

    }

    private void showJDialog(String filepath) {
        JDialog jDialog = new JDialog();
        JLabel jLabel = new JLabel(new ImageIcon(filepath));
        jLabel.setBounds(0, 0, 258, 258);
        jDialog.getContentPane().add(jLabel);
        jDialog.setSize(344, 344);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo((Component)null);
        jDialog.setModal(true);
        jDialog.setVisible(true);
    }
}
