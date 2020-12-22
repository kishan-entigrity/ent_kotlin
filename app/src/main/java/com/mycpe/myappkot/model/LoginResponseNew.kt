import com.google.gson.annotations.SerializedName

data class LoginResponseNew (

		@SerializedName("success") val success : Boolean,
		@SerializedName("message") val message : String,
		@SerializedName("payload") val payload : Payload
)