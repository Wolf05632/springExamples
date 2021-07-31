package quoters.profiling;

public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
