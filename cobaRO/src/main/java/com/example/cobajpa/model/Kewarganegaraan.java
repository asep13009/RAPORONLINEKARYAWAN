package com.example.cobajpa.model;

public enum Kewarganegaraan {
	IKA("Indonesia Keturunan Australoid"),
    IKC("Indonesia Keturunan Caucasoid"),
    IKE("Indonesia Keturunan Melanesoid"),
    IKM("Indonesia Keturunan Mongoloid"),
    IKN("Indonesia Keturunan Negroid"),
    WNA("Warga Negara Asing"),
    WNI("Warga Negara Indonesia"),
    WNK("Warga Negara Indonesia Keturunan");
	
	
	private String displayName;

	Kewarganegaraan(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
