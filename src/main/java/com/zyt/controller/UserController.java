package com.zyt.controller;

import com.zyt.domain.User;
import com.zyt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * User 控制器
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所用用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据ID查询用户
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null,null,null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("add", "userModel", model);
    }

    /**
     * 保存或修改用户
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 修改用户
     * @return
     */
    @GetMapping(value = "/modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("add", "userModel", model);
    }

}
