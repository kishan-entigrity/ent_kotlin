package com.mycpe.myappkot.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("payload")
	val payload: Payload? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class EducationItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Payload(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("industry_id")
	val industryId: String? = null,

	@field:SerializedName("education")
	val education: List<EducationItem?>? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("jobtitle_name")
	val jobtitleName: String? = null,

	@field:SerializedName("user_type")
	val userType: List<UserTypeItem?>? = null,

	@field:SerializedName("contact_no")
	val contactNo: String? = null,

	@field:SerializedName("jobtitle_id")
	val jobtitleId: Int? = null,

	@field:SerializedName("user_type_id")
	val userTypeId: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state_id")
	val stateId: Int? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("credit")
	val credit: Int? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("industry_name")
	val industryName: String? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("profile_picture")
	val profilePicture: String? = null,

	@field:SerializedName("education_ids")
	val educationIds: String? = null,

	@field:SerializedName("ptin_number")
	val ptinNumber: String? = null,

	@field:SerializedName("tags")
	val tags: List<Any?>? = null,

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("zipcode")
	val zipcode: String? = null,

	@field:SerializedName("ctec_id")
	val ctecId: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("company_name")
	val companyName: String? = null,

	@field:SerializedName("firm_name")
	val firmName: String? = null,

	@field:SerializedName("designation")
	val designation: String? = null,

	@field:SerializedName("country_id")
	val countryId: Int? = null,

	@field:SerializedName("city_id")
	val cityId: Int? = null
)

data class UserTypeItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
