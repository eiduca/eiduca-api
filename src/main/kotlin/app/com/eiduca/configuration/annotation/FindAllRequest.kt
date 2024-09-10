package app.com.eiduca.configuration.annotation

import app.com.eiduca.module.core.constant.MessageDoc
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import java.lang.annotation.Inherited

@Inherited
@ApiResponses(value = [ ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED) ])
annotation class FindAllRequest
