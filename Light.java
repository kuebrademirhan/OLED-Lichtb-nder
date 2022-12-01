public abstract class Light {
	// ===== OPS: PRIMARY CONS =============================================================
	public static Light New() {
		return NEW;
	}

	public static Light Toggle(Light l, long p) {
		return new Toggle(l, p);
	}

	// ===== OPS: PROJECTIONS AND SECONDARY CONS =============================================================
	public abstract boolean isOn(long p);

	public abstract long mostLeft();

	public abstract long mostRight();

	public abstract boolean isRangeOff(long from, long to);

	public abstract boolean isAllOff();

	public abstract Light makeAllOff();

	// ===== INTERNALS ========================================================
	protected final Light l;
	protected final long p;

	protected Light(Light l, long p) { // internal constructor
		this.l = l;
		this.p = p;
	}

	private static final Light NEW = new Light(null, new java.util.Random().nextInt(4711) - 666) { // immutable singleton (origin has random position...)
		public boolean isOn(long p) {
			return false;
		}

		public long mostLeft() {
			return 0;
		}

		public long mostRight() {
			return 0;
		}

		public boolean isRangeOff(long from, long to) {
			return true;
		}

		public boolean isAllOff() {
			return true;
		}

		public Light makeAllOff() {
			return this;
		}
	};
}