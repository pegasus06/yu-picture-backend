package com.ruizhou.picturebackend.controller;

import com.ruizhou.picturebackend.annotation.AuthCheck;
import com.ruizhou.picturebackend.common.BaseResponse;
import com.ruizhou.picturebackend.common.ResultUtils;
import com.ruizhou.picturebackend.model.constant.UserConstant;
import com.ruizhou.picturebackend.model.dto.PictureUploadRequest;
import com.ruizhou.picturebackend.model.entity.User;
import com.ruizhou.picturebackend.model.vo.PictureVO;
import com.ruizhou.picturebackend.service.PictureService;
import com.ruizhou.picturebackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class PictureController {
    @Resource
    private UserService userService;
    @Resource
    private PictureService pictureService;
    /**
     * 上传图片（可重新上传）
     */
    @PostMapping("/upload")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<PictureVO> uploadPicture(
            @RequestPart("file") MultipartFile multipartFile,
            PictureUploadRequest pictureUploadRequest,
            HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        PictureVO pictureVO = pictureService.uploadPicture(multipartFile, pictureUploadRequest, loginUser);
        return ResultUtils.success(pictureVO);
    }

}
