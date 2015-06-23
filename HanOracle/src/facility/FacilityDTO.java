package facility;

public class FacilityDTO {

	private int p_number;
	private int f_number;
	private double lat;
	private double lon;
	
	public FacilityDTO(int p_number, int f_number, double lat, double lon) {
		this.p_number=p_number;
		this.f_number=f_number;
		this.lat=lat;
		this.lon=lon;
		
	}
	public int getP_number() {
		return p_number;
	}
	public void setP_number(int p_number) {
		this.p_number = p_number;
	}
	public int getF_number() {
		return f_number;
	}
	public void setF_number(int f_number) {
		this.f_number = f_number;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
}
