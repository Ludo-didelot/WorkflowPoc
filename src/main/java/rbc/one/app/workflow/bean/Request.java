package rbc.one.app.workflow.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class Request {
	 	public Request(Long id, String idCalculated, String idClient, String jsonRequestObject, String objectType) {
		super();
		this.id = id;
		this.idCalculated = idCalculated;
		this.idClient = idClient;
		this.jsonRequestObject = jsonRequestObject;
		this.objectType = objectType;
	}
		public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
		@Id
	    @GeneratedValue
	    private Long id;
	    private String idCalculated;
	    private String idClient;
	    @Lob
	    private String jsonRequestObject;
	    
	    private String objectType;
		public Request(String idCalculated, String idClient, String jsonRequestObject,String objectType) {
			this.setIdCalculated(idCalculated)
			.setIdClient(idClient)
			.setJsonRequestObject(jsonRequestObject)
			.setObjectType(objectType);
		}
		public String getObjectType() {
			return objectType;
		}
		public Request setObjectType(String objectType) {
			this.objectType = objectType;
			return this;
		}
		public Long getId() {
			return id;
		}
		public Request setId(Long id) {
			this.id = id;
			return this;
		}
		public String getIdCalculated() {
			return idCalculated;
		}
		public Request setIdCalculated(String idCalculated) {
			this.idCalculated = idCalculated;
			return this;
		}
		public String getIdClient() {
			return idClient;
		}
		public Request setIdClient(String idClient) {
			this.idClient = idClient;
			return this;
		}
		public Object getJsonRequestObject() {
			return jsonRequestObject;
		}
		public Request setJsonRequestObject(String jsonRequestObject) {
			this.jsonRequestObject = jsonRequestObject;
			return this;
		}
	    
}
