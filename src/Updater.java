public class Updater extends Thread {
    public void run() {
        while (true) {
            Interface.speedl.setText(Interface.speed + " pnts/s");
            Interface.click.requestFocus();

            int p = Integer.parseInt(Interface.amount.getText());

            if (p < 25) {
                Interface.addClicker.setEnabled(false);
            } else {
                Interface.addClicker.setEnabled(true);
            }
            if (p < 100) {
                Interface.addGrandma.setEnabled(false);
            } else {
                Interface.addGrandma.setEnabled(true);
            }
            if (p < 500) {
                Interface.addFarm.setEnabled(false);
            } else {
                Interface.addFarm.setEnabled(true);
            }
            if (p < 2000) {
                Interface.addMine.setEnabled(false);
            } else {
                Interface.addMine.setEnabled(true);
            }
        }
    }
}
