package com.example.cobajpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Wilayah {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idWilayah;

	    @Column(length = 30)
	    private String namaWilayah;

	    @Column(length = 10)
	    private Integer level;
	    @OneToOne(mappedBy = "wilayah")
	    private Alamat alamat;

	    @ManyToOne
	    private Wilayah wilayah;

	    @OneToMany(mappedBy = "wilayah")
	    private List<Wilayah> wilayahs;

	    public Wilayah() {
	    }

	    public Wilayah(Long idWilayah, String namaWilayah, Integer level) {
	        this.idWilayah = idWilayah;
	        this.namaWilayah = namaWilayah;
	        this.level = level;
	    }

	    public Long getId() {
	        return getIdWilayah();
	    }

	    public void setId(Long id) {
	        this.setIdWilayah(id);
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (getIdWilayah() != null ? getIdWilayah().hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Wilayah)) {
	            return false;
	        }
	        Wilayah other = (Wilayah) object;
	        if ((this.getIdWilayah() == null && other.getIdWilayah() != null) || (this.getIdWilayah() != null && !this.idWilayah.equals(other.idWilayah))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "model.Wilayah[ id=" + getIdWilayah() + " ]";
	    }

	    /**
	     * @return the idWilayah
	     */
	    public Long getIdWilayah() {
	        return idWilayah;
	    }

	    /**
	     * @param idWilayah the idWilayah to set
	     */
	    public void setIdWilayah(Long idWilayah) {
	        this.idWilayah = idWilayah;
	    }

	    /**
	     * @return the namaWilayah
	     */
	    public String getNamaWilayah() {
	        return namaWilayah;
	    }

	    /**
	     * @param namaWilayah the namaWilayah to set
	     */
	    public void setNamaWilayah(String namaWilayah) {
	        this.namaWilayah = namaWilayah;
	    }

	    /**
	     * @return the level
	     */
	    public Integer getLevel() {
	        return level;
	    }

	    /**
	     * @param level the level to set
	     */
	    public void setLevel(Integer level) {
	        this.level = level;
	    }

	    public Alamat getAlamat() {
	        return alamat;
	    }

	    public void setAlamat(Alamat alamat) {
	        this.alamat = alamat;
	    }

	    public Wilayah getWilayah() {
	        return wilayah;
	    }

	    public void setWilayah(Wilayah wilayah) {
	        this.wilayah = wilayah;
	    }

	    public List<Wilayah> getWilayahs() {
	        return wilayahs;
	    }

	    public void setWilayahs(List<Wilayah> wilayahs) {
	        this.wilayahs = wilayahs;
	    }
}
