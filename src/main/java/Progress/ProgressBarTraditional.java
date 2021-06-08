package Progress;

class ProgressBarTraditional implements Runnable {
    boolean showProgress = true;
    public void run() {
        String anim  = "=====================";
        int x = 0;
        while (showProgress) {
            System.out.print("\r Processing "
                    + anim.substring(0, x++ % anim.length())
                    + " ");
            try { Thread.sleep(100); }
            catch (Exception e) {};
        }
    }
}