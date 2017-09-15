package opFrame;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;

import org.jvnet.substance.border.GlassInnerBorderPainter;

import org.jvnet.substance.button.StandardButtonShaper;

import org.jvnet.substance.title.Glass3DTitlePainter;


import opFrame.Login;

public class Main {

	public static void main(String[] args) throws Exception {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel());
					UIManager.setLookAndFeel(new SubstanceLookAndFeel());
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setCurrentButtonShaper(new StandardButtonShaper());
					SubstanceLookAndFeel.setCurrentBorderPainter(new GlassInnerBorderPainter());
					SubstanceLookAndFeel.setCurrentTitlePainter(new Glass3DTitlePainter());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				@SuppressWarnings("unused")
				Login login = new Login();
			}
		});
	}
}
