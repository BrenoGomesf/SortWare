package main;

public class Spinner  extends Thread {
    boolean showProgress = true;

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    public void run() {
        String anim= "|/-\\";
        int x = 0;
        while (showProgress) {
            System.out.print("\r Processando " + anim.charAt(x++ % anim.length()));
            try { Thread.sleep(100); }
            catch (Exception erro) {
                System.out.println(erro.getMessage());
            };
        }
    }
}
