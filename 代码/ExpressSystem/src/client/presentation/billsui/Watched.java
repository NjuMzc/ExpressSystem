package client.presentation.billsui;

public interface Watched {

	public void addWatcher(Watcher watcher);
	public void removeWatcehr(Watcher watcher);
	public void notifyWatchers(State state);
}
