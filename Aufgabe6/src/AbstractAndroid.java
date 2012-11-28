public abstract class AbstractAndroid {
	protected final int seriennummer;
	protected AbstractSoftware software;
	protected AbstractSkin skin;
	protected AbstractKit kit;
	
	public AbstractAndroid(int seriennummer) {
		this.seriennummer = seriennummer;
		this.software = null;
		this.skin = null;
		this.kit = null;
	}

	/* === GETTER === */
	
	// Seriennummer hat nur getter, darf nicht veraendert werden
	public int getSeriennummer() {
		return seriennummer;
	}

	public AbstractSoftware getSoftware() {
		return software;
	}
	
	public AbstractSkin getSkin() {
		return skin;
	}

	public AbstractKit getKit() {
		return kit;
	}

	/* === SETTER === */
	
	//public abstract void setSoftware(AbstractSoftware software, AbstractSecurity sec);

	public abstract void setSkin(AbstractSkin skin);
	
	
	public abstract void setKit(AbstractKit kit, Security1 security);
	public abstract void setKit(AbstractKit kit, Security2 security);
	public abstract void setKit(AbstractKit kit, Security3 security);
	public abstract void setKit(AbstractKit kit, Security4 security);
	public abstract void setKit(AbstractKit kit, Security5 security);
	
	/* === other methods === */
	
}
