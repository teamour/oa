/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : oasys

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-29 20:14:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_login_record
-- ----------------------------
DROP TABLE IF EXISTS `log_login_record`;
CREATE TABLE `log_login_record` (
  `login_record_id` int(11) NOT NULL COMMENT '登录记录id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ip` int(11) DEFAULT NULL COMMENT '登录ip',
  `client_os` varchar(255) DEFAULT NULL COMMENT '客户操作系统',
  `client_browser` varchar(255) DEFAULT NULL COMMENT '客户断浏览器信息',
  `source` tinyint(4) DEFAULT NULL COMMENT '来源',
  PRIMARY KEY (`login_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录记录';

-- ----------------------------
-- Records of log_login_record
-- ----------------------------

-- ----------------------------
-- Table structure for log_operation_record
-- ----------------------------
DROP TABLE IF EXISTS `log_operation_record`;
CREATE TABLE `log_operation_record` (
  `operation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作的自动id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `operate_path` varchar(255) DEFAULT NULL COMMENT '操作对应controller里的路径',
  `operate_content` varchar(5000) DEFAULT NULL COMMENT '操作的参数/dto/model',
  PRIMARY KEY (`operation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户操作记录';

-- ----------------------------
-- Records of log_operation_record
-- ----------------------------

-- ----------------------------
-- Table structure for sys_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_action`;
CREATE TABLE `sys_action` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作id',
  `action_name` varchar(50) DEFAULT NULL COMMENT '操作名称(ex:新规，修改)',
  `action_code` varchar(50) DEFAULT NULL COMMENT '操作的代号（ex:新规 ->add）',
  `sort_order` int(11) DEFAULT NULL COMMENT '页面显示排序',
  `status` bit(1) DEFAULT b'1' COMMENT '是否可用(0:禁用 1:可用)',
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作表(ex:add,delete,update...)';

-- ----------------------------
-- Records of sys_action
-- ----------------------------

-- ----------------------------
-- Table structure for sys_app
-- ----------------------------
DROP TABLE IF EXISTS `sys_app`;
CREATE TABLE `sys_app` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '应用的id',
  `app_name` varchar(50) DEFAULT NULL COMMENT '应用的名称',
  `app_url` varchar(255) DEFAULT NULL COMMENT '应用的链接地址',
  `app_icon` varchar(255) DEFAULT NULL COMMENT '应用的图标',
  `sort_order` int(11) DEFAULT '0' COMMENT '应用显示排序',
  `status` bit(1) DEFAULT b'1' COMMENT '应用是否可用(0:禁用 1:可用)',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='app表';

-- ----------------------------
-- Records of sys_app
-- ----------------------------

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sys_company`;
CREATE TABLE `sys_company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `company_code` varchar(255) DEFAULT NULL COMMENT '公司英文缩写',
  `address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `zip_code` varchar(50) DEFAULT NULL COMMENT '邮编',
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL COMMENT '公司电话号码',
  `website` varchar(255) DEFAULT NULL COMMENT '公司网址',
  `is_bp` bit(1) DEFAULT b'0' COMMENT '是否是bp公司 （0:否 1:是）',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '口座銀行',
  `branch_bank` varchar(255) DEFAULT NULL COMMENT '口座支店',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '口座番号',
  `bank_desc` varchar(255) DEFAULT NULL COMMENT '口座備考',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司表(包含bp)';

-- ----------------------------
-- Records of sys_company
-- ----------------------------
INSERT INTO `sys_company` VALUES ('1', 'OUR株式会社', 'OUR', '东京1 详细地址1', '111-1111', 'our@111.com', '111-1111-1111', 'our.com', '\0', 'みずほ銀行', '001', '024', 'what this?', null, null, null, '\0');
INSERT INTO `sys_company` VALUES ('2', 'TES株式会社', 'TES', '东京2 详细地址2', '222-2222', 'tes@222.com', '222-2222-2222', 'test.com', '\0', 'みずほ銀行', '002', '021', 'gg', null, null, null, '\0');
INSERT INTO `sys_company` VALUES ('3', '暂时不存在的测试会社', 'Nameless', 'unknownplace', '000-0000', 'nl@000.com', '000-0000-0000', 'un.com', '\0', 'nobank', '000', '000', null, null, null, null, '\0');

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `dept_code` varchar(255) DEFAULT NULL COMMENT '部门code',
  `parent_dept_id` int(11) DEFAULT NULL COMMENT '父部门id(扩展多级部门)',
  `company_id` int(11) DEFAULT NULL COMMENT '所属公司',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`dept_id`),
  KEY `fk_company_dept_companyid` (`company_id`),
  CONSTRAINT `fk_company_dept_companyid` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `dict_name` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述/备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='字典表(保存枚举的项目，供页面选择用)';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('1', '公司性质', '客户', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('2', '合作意向', '客户', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('3', '上场或者非上场', '客户', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('4', '面情结果', 'hr', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('5', '学历', 'hr', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('6', 'マナー', 'hr', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('7', '在职情况', 'hr', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('8', '婚姻情况', 'hr', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('9', '工作意向', 'hr', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('10', '是否已删除', 'hr', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('11', '材料准备情况', 'visa', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('12', '邮寄情况', 'visa', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('13', '申请材料', 'visa', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('14', '自译日历简历', 'visa', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('15', '简历翻译检查', 'visa', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('16', '技术评星', 'employee', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('17', '日语等级', 'employee', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('18', '技术等级', 'employee', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('19', '职位', 'employee', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('20', '自社', 'company', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('21', '请求书模板', 'document_invoice', null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('22', '发注书模板', 'document_purchase', null, null, null, '\0');

-- ----------------------------
-- Table structure for sys_dictionary_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary_detail`;
CREATE TABLE `sys_dictionary_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典子项目id',
  `detail_name` varchar(255) DEFAULT NULL COMMENT '字典子项目名称',
  `detail_code` varchar(255) DEFAULT NULL COMMENT '字典子项目code',
  `dict_id` int(11) DEFAULT NULL COMMENT '对应的字典id',
  `sort_order` int(11) DEFAULT NULL COMMENT '子项目显示排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`detail_id`),
  KEY `fk_dict_detail_dictid` (`dict_id`),
  CONSTRAINT `fk_dict_detail_dictid` FOREIGN KEY (`dict_id`) REFERENCES `sys_dictionary` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='字典子表';

-- ----------------------------
-- Records of sys_dictionary_detail
-- ----------------------------
INSERT INTO `sys_dictionary_detail` VALUES ('1', '日企', null, '1', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('2', '中国公司', null, '1', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('3', '无', null, '2', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('4', '低', null, '2', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('5', '中', null, '2', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('6', '高', null, '2', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('7', '合作过', null, '2', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('8', '合作中', null, '2', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('9', '上场', null, '3', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('10', '非上场', null, '3', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('11', '合格', null, '4', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('12', '不合格', null, '4', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('13', '大专', null, '5', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('14', '本科', null, '5', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('15', '硕士', null, '5', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('16', '博士', null, '5', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('17', '1', null, '6', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('18', '2', null, '6', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('19', '3', null, '6', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('20', '4', null, '6', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('21', '5', null, '6', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('22', '在职', null, '7', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('23', '离职', null, '7', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('24', '已婚', null, '8', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('25', '未婚', null, '8', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('26', '1', null, '9', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('27', '2', null, '9', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('28', '3', null, '9', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('29', '是', null, '10', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('30', '否', null, '10', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('31', '未准备', null, '11', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('32', '准备中', null, '11', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('33', '准备完成', null, '11', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('34', '未邮寄', null, '12', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('35', '邮寄中', null, '12', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('36', '已收到', null, '12', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('37', '是', null, '13', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('38', '否', null, '13', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('39', '有', null, '14', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('40', '无', null, '14', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('41', '未检查', null, '15', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('42', '已检查', null, '15', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('43', 'いち', null, '16', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('44', 'に', null, '16', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('45', 'さん', null, '16', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('46', 'よん', null, '16', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('47', 'N1', null, '17', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('48', 'N2', null, '17', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('49', 'N3', null, '17', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('50', 'N4', null, '17', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('51', 'N5', null, '17', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('52', '大佬(比N1还厉害)', null, '17', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('53', 'PT', null, '18', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('54', 'PG', null, '18', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('55', 'BSE', null, '18', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('56', 'SE', null, '18', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('57', 'TL', null, '18', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('58', 'PM(Product Manager)产品经理', null, '19', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('59', 'PL(Project Leader)项目组长 ', null, '19', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('60', 'SE(System Engineer) 系统工程师', null, '19', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('61', 'PG(开发人员)', null, '19', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('62', 'PT(Project Test)', null, '19', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('63', 'OUR', null, '20', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('64', 'TES', null, '20', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('65', '请求书模板（默认）', null, '21', null, null, null, null, '\0');
INSERT INTO `sys_dictionary_detail` VALUES ('66', '请求书模板2（没东西）', null, '21', null, null, null, null, '\0');

-- ----------------------------
-- Table structure for sys_filter_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_filter_item`;
CREATE TABLE `sys_filter_item` (
  `filter_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目权限id',
  `filter_item_name` varchar(255) DEFAULT NULL COMMENT '项目权限名称',
  `filter_path` varchar(255) DEFAULT NULL COMMENT '项目权限要拦截的路径',
  `filter_obj_name` varchar(255) DEFAULT NULL COMMENT '项目权限要拦截处理model或dto中field字段名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`filter_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目权限设置，过滤指定路径下的dto或model的字段';

-- ----------------------------
-- Records of sys_filter_item
-- ----------------------------

-- ----------------------------
-- Table structure for sys_filter_item_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_filter_item_role`;
CREATE TABLE `sys_filter_item_role` (
  `role_id` int(11) NOT NULL,
  `filter_item_id` int(11) NOT NULL,
  KEY `fk_role_filter_item_role_roleid` (`role_id`),
  KEY `fk_filter_item_filter_item_role_filteritemid` (`filter_item_id`),
  CONSTRAINT `fk_filter_item_filter_item_role_filteritemid` FOREIGN KEY (`filter_item_id`) REFERENCES `sys_filter_item` (`filter_item_id`),
  CONSTRAINT `fk_role_filter_item_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色 对应的 项目权限设置 ';

-- ----------------------------
-- Records of sys_filter_item_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块的id',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `module_path` varchar(255) DEFAULT NULL COMMENT '模块的路径（对应controller里的mapping路径）',
  `module_icon` varchar(255) DEFAULT NULL COMMENT '模块的图标',
  `app_id` int(11) DEFAULT NULL COMMENT '所属app',
  `parent_module_id` int(11) DEFAULT NULL COMMENT '父模块的id',
  `sort_order` int(11) DEFAULT NULL COMMENT '模块排序',
  `status` bit(1) DEFAULT b'1' COMMENT '模块状态(0:禁用 1:可用)',
  PRIMARY KEY (`module_id`),
  KEY `fk_app_module_appid` (`app_id`),
  CONSTRAINT `fk_app_module_appid` FOREIGN KEY (`app_id`) REFERENCES `sys_app` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块表';

-- ----------------------------
-- Records of sys_module
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述/备注',
  `sort_order` int(11) DEFAULT NULL COMMENT '显示排序',
  `status` bit(1) DEFAULT b'1' COMMENT '是否可用(0:禁用 1:可用)',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module`;
CREATE TABLE `sys_role_module` (
  `role_module_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `module_id` int(11) DEFAULT NULL COMMENT '模块id',
  PRIMARY KEY (`role_module_id`),
  KEY `fk_role_role_module_roleid` (`role_id`),
  KEY `fk_module_role_module_moduleid` (`module_id`),
  CONSTRAINT `fk_module_role_module_moduleid` FOREIGN KEY (`module_id`) REFERENCES `sys_module` (`module_id`),
  CONSTRAINT `fk_role_role_module_roleid` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色模块表';

-- ----------------------------
-- Records of sys_role_module
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_module_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module_action`;
CREATE TABLE `sys_role_module_action` (
  `role_module_id` int(11) NOT NULL COMMENT '角色模块的id',
  `action_id` int(11) NOT NULL COMMENT '操作id',
  KEY `fk_role_module_role_module_action_rolemoduleid` (`role_module_id`),
  KEY `fk_action_role_module_action_actionid` (`action_id`),
  CONSTRAINT `fk_action_role_module_action_actionid` FOREIGN KEY (`action_id`) REFERENCES `sys_action` (`action_id`),
  CONSTRAINT `fk_role_module_role_module_action_rolemoduleid` FOREIGN KEY (`role_module_id`) REFERENCES `sys_role_module` (`role_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色模块操作表';

-- ----------------------------
-- Records of sys_role_module_action
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `error_number` int(11) DEFAULT NULL COMMENT '错误次数',
  `email_verification_code` varchar(10) DEFAULT NULL COMMENT '邮箱验证码',
  `verification_code_send_time` datetime DEFAULT NULL COMMENT '验证发送时间',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`user_id`),
  KEY `fk_employee_user_employeeid` (`employee_id`),
  CONSTRAINT `fk_employee_user_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `t_employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '123', null, null, null, null, null, null, null, null, null, null, '\0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  KEY `fk_user_user_role_userid` (`user_id`),
  KEY `fk_role_user_role_roleid` (`role_id`),
  CONSTRAINT `fk_role_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `fk_user_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_announcement
-- ----------------------------
DROP TABLE IF EXISTS `t_announcement`;
CREATE TABLE `t_announcement` (
  `announcement_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(255) DEFAULT NULL COMMENT '公告标题',
  `description` text COMMENT '公告内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`announcement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告表';

-- ----------------------------
-- Records of t_announcement
-- ----------------------------

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户公司名称',
  `website` varchar(255) DEFAULT NULL COMMENT '客户网址',
  `registered_capital` int(11) DEFAULT NULL COMMENT '资本金',
  `employee_number` int(11) DEFAULT NULL COMMENT '社员数',
  `establish_date` date DEFAULT NULL COMMENT '成立日',
  `company_type` int(11) DEFAULT NULL COMMENT '公司性质(对应字典表)',
  `address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `zip_code` varchar(50) DEFAULT NULL COMMENT '邮编',
  `ceo` varchar(50) DEFAULT NULL COMMENT '代表取缔役',
  `main_business` varchar(255) DEFAULT NULL COMMENT '主要业务',
  `cooperation_direction` varchar(255) DEFAULT NULL COMMENT '和本公司的合作方向',
  `cooperation_intention` int(11) DEFAULT NULL COMMENT '合作意向（对应字典表）',
  `is_upper` bit(1) DEFAULT NULL COMMENT '上场或者非上场（0:非上场 1:上场）',
  `contact_channel` varchar(255) DEFAULT NULL COMMENT '联系渠道',
  `sales_staff` varchar(255) DEFAULT NULL COMMENT '营业担当',
  `sales_telephone` varchar(255) DEFAULT NULL COMMENT '营业电话',
  `sales_email` varchar(255) DEFAULT NULL COMMENT '营业邮箱',
  `skill_require` varchar(255) DEFAULT NULL COMMENT '技术需求',
  `proposal1_email` varchar(255) DEFAULT NULL COMMENT '提案用邮箱1',
  `proposal1_handler` varchar(255) DEFAULT NULL COMMENT '提案用担当1',
  `proposal2_email` varchar(255) DEFAULT NULL COMMENT '提案用邮箱2',
  `proposal2_handler` varchar(255) DEFAULT NULL COMMENT '提案用担当2',
  `proposal3_email` varchar(255) DEFAULT NULL COMMENT '提案用邮箱3',
  `proposal3_handler` varchar(255) DEFAULT NULL COMMENT '提案用担当3',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '世嘉', 'www.SEGA .com', '300000', '20', '2019-05-01', '0', '新宿', 'SEGA＠gmail.com', 'David Rosen', '游戏开发', '永久', '4', '\0', '网络', '杨桑', '133333333', '', '', 'tigerhu33@gmail.com', '胡然', '', '', '', '', null, null, null, null);

-- ----------------------------
-- Table structure for t_document_invoice
-- ----------------------------
DROP TABLE IF EXISTS `t_document_invoice`;
CREATE TABLE `t_document_invoice` (
  `invoice_document_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求书id',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `customer_address` varchar(255) DEFAULT NULL COMMENT '客户地址',
  `customer_charge` varchar(255) DEFAULT NULL COMMENT '客户负责人姓名',
  `company_id` int(11) DEFAULT NULL COMMENT '自社id',
  `pay_deadline` varchar(255) DEFAULT NULL COMMENT '付款期限',
  `unit_price` int(11) DEFAULT NULL COMMENT '単価',
  `template_id` int(11) DEFAULT NULL COMMENT '文档模板id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`invoice_document_id`),
  KEY `fk_customer_document_invoice_customerid` (`customer_id`),
  KEY `fk_company_document_invoice_companyid` (`company_id`),
  KEY `fk_template_invoice_templateid` (`template_id`),
  CONSTRAINT `fk_company_document_invoice_companyid` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`company_id`),
  CONSTRAINT `fk_customer_document_invoice_customerid` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`customer_id`),
  CONSTRAINT `fk_template_invoice_templateid` FOREIGN KEY (`template_id`) REFERENCES `t_document_template` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请求书';

-- ----------------------------
-- Records of t_document_invoice
-- ----------------------------

-- ----------------------------
-- Table structure for t_document_purchase
-- ----------------------------
DROP TABLE IF EXISTS `t_document_purchase`;
CREATE TABLE `t_document_purchase` (
  `purchase_document_id` int(11) NOT NULL COMMENT '发注书id',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `unit_price` int(11) DEFAULT NULL COMMENT '单价',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `settlement_time` varchar(255) DEFAULT NULL COMMENT '精算时间',
  `template_id` int(11) DEFAULT NULL COMMENT '文档模板id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`purchase_document_id`),
  KEY `fk_project_document_purchase_projectid` (`project_id`),
  KEY `fk_employee_document_purchase_employeeid` (`employee_id`),
  KEY `fk_template_purchase_templateid` (`template_id`),
  CONSTRAINT `fk_employee_document_purchase_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `t_employee` (`employee_id`),
  CONSTRAINT `fk_project_document_purchase_projectid` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`),
  CONSTRAINT `fk_template_purchase_templateid` FOREIGN KEY (`template_id`) REFERENCES `t_document_template` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发注书';

-- ----------------------------
-- Records of t_document_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for t_document_template
-- ----------------------------
DROP TABLE IF EXISTS `t_document_template`;
CREATE TABLE `t_document_template` (
  `template_id` int(11) NOT NULL COMMENT '文档模板id',
  `template_name` varchar(255) DEFAULT NULL COMMENT '文档模板名称',
  `template_file` varchar(255) DEFAULT NULL COMMENT '文档模板文件',
  `template_type` tinyint(4) DEFAULT NULL COMMENT '文档模板类型(1:请求书 2:发注书)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文档模板表';

-- ----------------------------
-- Records of t_document_template
-- ----------------------------
INSERT INTO `t_document_template` VALUES ('1', '请求书1', 'resource\\document\\template\\9e07859e-9609-4e59-bb12-2222bdb5b292.xls', '1', null, null, null, '\0');
INSERT INTO `t_document_template` VALUES ('2', '请求书2', null, '1', null, null, null, '\0');
INSERT INTO `t_document_template` VALUES ('3', '发注书1', null, '2', null, null, null, '\0');
INSERT INTO `t_document_template` VALUES ('4', '发注书2', null, '2', null, null, null, '\0');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `marital_status` int(4) DEFAULT NULL COMMENT '婚姻状况',
  `company_id` int(11) DEFAULT NULL COMMENT '所属公司',
  `dept_id` int(11) DEFAULT NULL COMMENT '所属部门',
  `enter_date` date DEFAULT NULL COMMENT '入社日期',
  `position` int(11) DEFAULT NULL COMMENT '职位（对应字典表中的detailid）',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `the_nearest_station` varchar(255) DEFAULT NULL COMMENT '最寄り駅',
  `telephone` varchar(255) DEFAULT NULL COMMENT '電話番号',
  `working_years` tinyint(4) DEFAULT NULL COMMENT '总经验年数',
  `skill1` int(11) DEFAULT NULL COMMENT '技术1（对应字典详细表里的id）',
  `skill1_years` tinyint(4) DEFAULT NULL COMMENT '技术1的工作年数',
  `skill2` int(11) DEFAULT NULL,
  `skill2_years` tinyint(4) DEFAULT NULL,
  `skill3` int(11) DEFAULT NULL,
  `skill3_years` tinyint(4) DEFAULT NULL,
  `skill_score` tinyint(4) DEFAULT NULL COMMENT '技术评价（1-5星）',
  `skill_analysis` text COMMENT '技术分析',
  `skill_growth` text COMMENT '技术发展',
  `skill_level` int(11) DEFAULT NULL COMMENT '技术level（对应字典表）',
  `japanese_level` int(11) DEFAULT NULL COMMENT '日语level（对应字典表）',
  `salary` int(11) DEFAULT NULL COMMENT '給料',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '口座銀行',
  `branch_bank` varchar(255) DEFAULT NULL COMMENT '口座支店',
  `bank_number` varchar(255) DEFAULT NULL COMMENT '口座番号',
  `bank_desc` varchar(255) DEFAULT NULL COMMENT '口座備考',
  `domestic_address` varchar(255) DEFAULT NULL COMMENT '国内住所',
  `family_support` tinyint(4) DEFAULT NULL COMMENT '扶養家族人数',
  `contract_format` int(11) DEFAULT NULL COMMENT '契約形式(对应字典表)',
  `employment_insurance` bit(1) DEFAULT b'0' COMMENT '雇用保険加入(0:未加入 1:加入)',
  `annuity` bit(1) DEFAULT b'0' COMMENT '年金加入(0:未加入 1:加入)',
  `health_insurance` bit(1) DEFAULT b'0' COMMENT '健康保険加入(0:未加入 1:加入)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`employee_id`),
  KEY `fk_company_employee_companyid` (`company_id`),
  KEY `fk_dept_employee_deptid` (`dept_id`),
  CONSTRAINT `fk_company_employee_companyid` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`company_id`),
  CONSTRAINT `fk_dept_employee_deptid` FOREIGN KEY (`dept_id`) REFERENCES `sys_department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', '李老大', null, '99', null, null, null, null, null, null, '不远', '神泉', '666 6666 6666', '4', null, null, null, null, null, null, null, '', '1', '4', '2', null, '6666666', '6666666', ',,,', '6666666', '大连', '5', null, '\0', '\0', '\0', '2019-05-27 16:49:07', null, null, '\0');
INSERT INTO `t_employee` VALUES ('2', '王小二', null, '23', null, null, null, null, null, null, '下北泽', '下北泽', '777 7777 777', '1', null, null, null, null, null, null, null, '', '4', null, null, null, '123123123123', '12312312', '123123123,123123123,123123123,123123123', '123123', '', '5', null, '\0', '\0', '\0', '2019-05-27 17:03:16', null, null, '\0');
INSERT INTO `t_employee` VALUES ('3', '胡悍三', null, '99', null, null, null, null, null, null, '下北泽', '下北泽', '166 6666 6666', '2', null, null, null, null, null, null, null, '', '3', null, null, null, 'mizuho', '123', '123123', '123123', '天津', '2', null, '\0', '\0', '\0', '2019-05-27 17:16:23', null, null, '\0');
INSERT INTO `t_employee` VALUES ('4', '', null, null, null, null, null, null, null, null, '', '', '', null, null, null, null, null, null, null, null, '', '1', null, null, null, '', '', '', '', '', '1', null, null, null, null, '2019-05-29 20:08:02', null, null, '\0');

-- ----------------------------
-- Table structure for t_employee_site
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_site`;
CREATE TABLE `t_employee_site` (
  `employee_site_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工现场记录id',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `expect_enter_date` date DEFAULT NULL COMMENT '预定入场日期',
  `enter_date` date DEFAULT NULL COMMENT '入場日期',
  `end_date` date DEFAULT NULL COMMENT '現場終了日期',
  `sales_staff` varchar(255) DEFAULT NULL COMMENT '営業担当',
  `sales_contact` varchar(255) DEFAULT NULL COMMENT '営業連絡先',
  `sales_email` varchar(255) DEFAULT NULL COMMENT '営業メール',
  `office_clerk` varchar(255) DEFAULT NULL COMMENT '事務担当',
  `office_email` varchar(255) DEFAULT NULL COMMENT '事務メール',
  `settlement_range` varchar(255) DEFAULT NULL COMMENT '精算範囲',
  `unit_price` int(11) DEFAULT NULL COMMENT '単価',
  `is_need_sales_staff` bit(1) DEFAULT b'0' COMMENT '是否需要营业（0:否 1:是）',
  `purchase_order_file` varchar(255) DEFAULT NULL COMMENT '注文書(保存文件路径)',
  `invoice_file` varchar(255) DEFAULT NULL COMMENT '請求書',
  `payment_site` varchar(255) DEFAULT NULL COMMENT '支払いサイト',
  `head_office_clerk` varchar(255) DEFAULT '' COMMENT '本社事務担当',
  `enter_record` text COMMENT '现场入场相关记录',
  `enter_handler` int(255) DEFAULT NULL COMMENT '带入场担当',
  `is_end` bit(1) DEFAULT b'0' COMMENT '现场是否已经结束(0:未结束 1:已结束)',
  `description` text COMMENT '備考',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`employee_site_id`),
  KEY `fk_employee_employee_site_employeeid` (`employee_id`),
  KEY `fk_project_employee_site_projectid` (`project_id`),
  CONSTRAINT `fk_employee_employee_site_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `t_employee` (`employee_id`),
  CONSTRAINT `fk_project_employee_site_projectid` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='员工现场记录表';

-- ----------------------------
-- Records of t_employee_site
-- ----------------------------
INSERT INTO `t_employee_site` VALUES ('1', '1', null, null, null, null, '杨桑', '~~', '~~', '~~', '~~', '12213', '123123', '', '~~', '~~', '', '', '', null, null, '', null, '2019-05-29 19:58:56', null, '\0');
INSERT INTO `t_employee_site` VALUES ('2', '2', null, null, null, null, '赵桑', '', '23232', '2332', '322323', '23', '23', '', '', '', '', '', '', null, null, '', null, '2019-05-28 10:24:04', null, '\0');
INSERT INTO `t_employee_site` VALUES ('3', '3', null, null, null, null, '', '', '', '', '', '', null, '', '', '', '', '', '', null, '\0', '', null, null, null, '\0');
INSERT INTO `t_employee_site` VALUES ('4', '4', null, null, null, null, '', '', '', '', '', '', null, '', '', '', '', '', '', null, '\0', '', null, null, null, '\0');

-- ----------------------------
-- Table structure for t_employee_study
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_study`;
CREATE TABLE `t_employee_study` (
  `employee_study_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学习id',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `study_content` varchar(255) DEFAULT NULL COMMENT '学习内容',
  `begin_date` date DEFAULT NULL COMMENT '开始日期',
  `study_time` varchar(255) DEFAULT NULL COMMENT '学习时间',
  `handler` int(11) DEFAULT NULL COMMENT '负责人',
  `learn_cotent` varchar(255) DEFAULT NULL COMMENT '学会内容',
  `evaluation` varchar(255) DEFAULT NULL COMMENT '效果评价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`employee_study_id`),
  KEY `fk_employee_employee_study_employeeid` (`employee_id`),
  CONSTRAINT `fk_employee_employee_study_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `t_employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工学习表';

-- ----------------------------
-- Records of t_employee_study
-- ----------------------------

-- ----------------------------
-- Table structure for t_interviewer
-- ----------------------------
DROP TABLE IF EXISTS `t_interviewer`;
CREATE TABLE `t_interviewer` (
  `interviewer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '面试人员id',
  `interviewer_code` varchar(255) DEFAULT NULL COMMENT '面试人员编号',
  `interviewer_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `interview_result` bit(1) DEFAULT NULL COMMENT '面情结果（1面，2面，3面任何一个为NG的时候，可以设置为不合格）',
  `interview1_time` datetime DEFAULT NULL COMMENT '1面的时间',
  `interview1_result` bit(1) DEFAULT NULL COMMENT '1面结果',
  `interview1_handler` varchar(255) DEFAULT NULL COMMENT '1面担当',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `japanese_socre` int(11) DEFAULT NULL COMMENT '日语分数（对应字典表）',
  `japanese_conversation_ability` text COMMENT '日语会话能力',
  `graduated_school` varchar(255) DEFAULT NULL COMMENT '毕业大学',
  `profession` varchar(255) DEFAULT NULL COMMENT '专业',
  `graduated_date` date DEFAULT NULL COMMENT '毕业日期',
  `education` int(11) DEFAULT NULL COMMENT '学历（ex：大专，大学...,对应字典表）',
  `certificate` varchar(255) DEFAULT NULL COMMENT '资格证书',
  `manner` tinyint(4) DEFAULT NULL COMMENT 'マナー （1-5分）',
  `personnel_dept_feedback` text COMMENT '人事部意见',
  `interview1_desc` text COMMENT '1面备注',
  `personal_situation` text COMMENT '个人情况',
  `family_situation` varchar(255) DEFAULT NULL COMMENT '家庭情况',
  `service_situation` int(11) DEFAULT NULL COMMENT '在职情况（对应字典表）',
  `nationality` varchar(50) DEFAULT NULL COMMENT '民    族',
  `birthplace` varchar(50) DEFAULT NULL COMMENT '籍    贯',
  `marital_status` int(4) DEFAULT NULL COMMENT '婚姻状况（对应字典表）',
  `expect_salary` int(11) DEFAULT NULL COMMENT '期望薪资',
  `friendship_situation_in_japan` varchar(255) DEFAULT NULL COMMENT '在日朋友关系情况',
  `interview2_time` datetime DEFAULT NULL COMMENT '2面时间',
  `interview2_result` bit(1) DEFAULT NULL COMMENT '2面结果',
  `interview2_handler` varchar(255) DEFAULT NULL COMMENT '2面担当',
  `working_situation` text COMMENT '实际工作年数以及经验能力',
  `internship_experience` varchar(255) DEFAULT NULL COMMENT '实习经验',
  `skill_score` int(11) DEFAULT NULL COMMENT '技术分数（对应字典表）',
  `interview2_desc` text COMMENT '2面备注',
  `technical_department_feedback` text COMMENT '技术部意见',
  `interview3_time` datetime DEFAULT NULL COMMENT '3面时间',
  `interview3_result` bit(1) DEFAULT NULL COMMENT '3面结果',
  `interview3_handler` varchar(255) DEFAULT NULL COMMENT '3面担当',
  `interview3_desc` text COMMENT '3面备注',
  `prev1_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司1',
  `prev2_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司2',
  `prev3_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司3',
  `prev4_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司4',
  `prev5_company_name` varchar(255) DEFAULT NULL COMMENT '就职公司5',
  `work_intent` int(11) DEFAULT NULL COMMENT '工作意向(对应字典表，ex:后续联系（近期不赴日，但将来考虑赴日人员名单）)',
  `company_id` int(11) DEFAULT NULL COMMENT '招入公司id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`interviewer_id`),
  KEY `fk_company_interviewer_companyid` (`company_id`),
  CONSTRAINT `fk_company_interviewer_companyid` FOREIGN KEY (`company_id`) REFERENCES `sys_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='面试人员表';

-- ----------------------------
-- Records of t_interviewer
-- ----------------------------
INSERT INTO `t_interviewer` VALUES(1,'20190501001','ZS',0,'2019-05-01',0,1,1,20,null,80,null,null,null,'2010-06-01',1,null,2,null,null,null,null,1,null,null,1,1,null,'2019-05-05',1,1,null,null,50,null,null,'2019-05-05',1,1,null,null,null,null,null,null,0,1,'2019-01-01',null,null,0);
INSERT INTO `t_interviewer` VALUES(2,'20190501002','ZS',0,'2019-05-01',0,1,1,20,null,80,null,null,null,'2010-06-01',1,null,2,null,null,null,null,1,null,null,1,1,null,'2019-05-05',1,1,null,null,50,null,null,'2019-05-05',1,1,null,null,null,null,null,null,0,1,'2019-01-01',null,null,0);
INSERT INTO `t_interviewer` VALUES(3,'20190501003','ZS',0,'2019-05-01',0,1,1,20,null,80,null,null,null,'2010-06-01',1,null,2,null,null,null,null,1,null,null,1,1,null,'2019-05-05',1,1,null,null,50,null,null,'2019-05-05',1,1,null,null,null,null,null,null,0,1,'2019-01-01',null,null,0);
INSERT INTO `t_interviewer` VALUES(4,'20190501004','ZS',0,'2019-05-01',0,1,1,20,null,80,null,null,null,'2010-06-01',1,null,2,null,null,null,null,1,null,null,1,1,null,'2019-05-05',1,1,null,null,50,null,null,'2019-05-05',1,1,null,null,null,null,null,null,0,1,'2019-01-01',null,null,0);

-- ----------------------------
-- Table structure for t_interviewer_resume
-- ----------------------------
DROP TABLE IF EXISTS `t_interviewer_resume`;
CREATE TABLE `t_interviewer_resume` (
  `resume_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '简历id',
  `interviewer_id` int(11) DEFAULT NULL COMMENT '面试人员id',
  `resume_title` varchar(255) DEFAULT NULL COMMENT '简历标题',
  `resume_file` varchar(255) DEFAULT NULL COMMENT '简历文件链接',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`resume_id`),
  KEY `fk_interviewer_interviewer_resume_interviewerid` (`interviewer_id`),
  CONSTRAINT `fk_interviewer_interviewer_resume_interviewerid` FOREIGN KEY (`interviewer_id`) REFERENCES `t_interviewer` (`interviewer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='面试人员简历表';

-- ----------------------------
-- Records of t_interviewer_resume
-- ----------------------------

-- ----------------------------
-- Table structure for t_interviewer_test
-- ----------------------------
DROP TABLE IF EXISTS `t_interviewer_test`;
CREATE TABLE `t_interviewer_test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试验id',
  `interviewer_id` int(11) DEFAULT NULL COMMENT '面试人员id',
  `handler1` int(11) DEFAULT NULL COMMENT '担当1',
  `handler2` int(11) DEFAULT NULL COMMENT '担当2',
  `test_score` int(11) DEFAULT NULL COMMENT '考试分数',
  `is_pass` bit(1) DEFAULT b'0' COMMENT '合格否（0:不合格 1:合格）',
  `japanese_certificate` varchar(255) DEFAULT NULL COMMENT '日语资格证',
  `english_certificate` varchar(255) DEFAULT NULL COMMENT '英语资格证',
  `computer_certificate` varchar(255) DEFAULT NULL COMMENT '计算机资格证书',
  `japanese_listen` int(11) DEFAULT NULL COMMENT '日语听力',
  `japanese_speak` int(11) DEFAULT NULL COMMENT '日语口语',
  `japanese_read` int(11) DEFAULT NULL COMMENT '日语文档阅读',
  `japanese_write` int(11) DEFAULT NULL COMMENT '日语文档书写',
  `english_listen` int(11) DEFAULT NULL COMMENT '英语听力',
  `english_speak` int(11) DEFAULT NULL COMMENT '英语口语',
  `english_read` int(11) DEFAULT NULL COMMENT '英语文档阅读',
  `english_write` int(11) DEFAULT NULL COMMENT '英语文档书写',
  `skill_ability` text COMMENT '技术能力',
  `description` text COMMENT '备考',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`test_id`),
  KEY `fk_interviewer_interviewer_test_interviewerid` (`interviewer_id`),
  CONSTRAINT `fk_interviewer_interviewer_test_interviewerid` FOREIGN KEY (`interviewer_id`) REFERENCES `t_interviewer` (`interviewer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='面试人员IT適性試験';

-- ----------------------------
-- Records of t_interviewer_test
-- ----------------------------
INSERT INTO `t_interviewer_test` VALUES (1, 1, 1, 1, 11, b'0', '111', '11', '11', 11, 11, 11, 11, 11, 11, 11, 11, '11', '11', '2019-05-29 22:57:09', '2019-05-29 22:57:13', NULL, b'0');

-- ----------------------------
-- Table structure for t_interviewer_visa_handle
-- ----------------------------
DROP TABLE IF EXISTS `t_interviewer_visa_handle`;
CREATE TABLE `t_interviewer_visa_handle` (
  `visa_handle_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '签证办理id',
  `interviewer_id` int(11) DEFAULT NULL COMMENT '面试人员id',
  `material_prepare_situation` tinyint(4) DEFAULT '0' COMMENT '材料准备情况（0:未准备，1:准备中，2:准备结束）',
  `mailing_situation` tinyint(4) DEFAULT '0' COMMENT '邮寄情况（0:未邮寄，1:邮寄中，2:已收到）',
  `application_material` bit(1) DEFAULT b'0' COMMENT '申请材料(是否已经准备好 0：否 1：是)',
  `self_japanese_resume` bit(1) DEFAULT b'0' COMMENT '自译日文简历(0：没有 1：有)',
  `check_resume` bit(1) DEFAULT NULL COMMENT '简历翻译检查(0:未检查 1:检查)',
  `expect_submit_date` date DEFAULT NULL COMMENT '预计递交日',
  `actual_submit_date` date DEFAULT NULL COMMENT '实际递交日',
  `visa_handle_handler` int(11) DEFAULT NULL COMMENT '签证办理担当',
  `notice_handler` int(11) DEFAULT NULL COMMENT '赴日通知担当',
  `other_handlerf` int(11) DEFAULT NULL COMMENT '其它担当',
  `description` text COMMENT '备考',
  `is_completed` bit(1) DEFAULT b'0' COMMENT '是否完成关闭(0:否 1:是)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`visa_handle_id`),
  KEY `fk_interviewer_interviewer_visa_handle_interviewerid` (`interviewer_id`),
  CONSTRAINT `fk_interviewer_interviewer_visa_handle_interviewerid` FOREIGN KEY (`interviewer_id`) REFERENCES `t_interviewer` (`interviewer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='签证办理表';

-- ----------------------------
-- Records of t_interviewer_visa_handle
-- ----------------------------
INSERT INTO `t_interviewer_visa_handle` VALUES (1, 1, 0, 0, b'0', b'0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0');

-- ----------------------------
-- Table structure for t_mailing
-- ----------------------------
DROP TABLE IF EXISTS `t_mailing`;
CREATE TABLE `t_mailing` (
  `mailing_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '群发id',
  `mailing_aim_summary` varchar(255) DEFAULT NULL COMMENT '群发的目的或原因的概述',
  `mailing_templete_content` text COMMENT '群发的邮件模板内容',
  `begin_time` datetime DEFAULT NULL COMMENT '群发的开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '群发结束时间',
  `operator` int(11) DEFAULT NULL COMMENT '操作人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`mailing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群发邮件表';

-- ----------------------------
-- Records of t_mailing
-- ----------------------------

-- ----------------------------
-- Table structure for t_mailing_attachment
-- ----------------------------
DROP TABLE IF EXISTS `t_mailing_attachment`;
CREATE TABLE `t_mailing_attachment` (
  `mailing_attachment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `mailing_id` int(11) DEFAULT NULL COMMENT '群发邮件id',
  `mailing_attachment_title` varchar(255) DEFAULT NULL COMMENT '附件文件名称',
  `mailing_attachment_file` varchar(255) DEFAULT NULL COMMENT '附件文件路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`mailing_attachment_id`),
  KEY `fk_mailing_mailing_attachment_mailingid` (`mailing_id`),
  CONSTRAINT `fk_mailing_mailing_attachment_mailingid` FOREIGN KEY (`mailing_id`) REFERENCES `t_mailing` (`mailing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群发邮件附件表';

-- ----------------------------
-- Records of t_mailing_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for t_mailing_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_mailing_customer`;
CREATE TABLE `t_mailing_customer` (
  `mailing_id` int(11) NOT NULL COMMENT '群发id',
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `send_time` datetime DEFAULT NULL COMMENT '实际发送时间',
  `send_result` bit(1) DEFAULT b'0' COMMENT '发送结果(0:失败 1:成功)',
  KEY `fk_mailing_mailing_customer_mailingid` (`mailing_id`),
  KEY `fk_customer_mailing_customer_customerid` (`customer_id`),
  CONSTRAINT `fk_customer_mailing_customer_customerid` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`customer_id`),
  CONSTRAINT `fk_mailing_mailing_customer_mailingid` FOREIGN KEY (`mailing_id`) REFERENCES `t_mailing` (`mailing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件发送客户记录表';

-- ----------------------------
-- Records of t_mailing_customer
-- ----------------------------

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '案件名id',
  `project_name` varchar(255) DEFAULT NULL COMMENT '案件名',
  `project_desc` text COMMENT '案件详细',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `settlement_range` varchar(255) DEFAULT NULL COMMENT '精算範囲',
  `site_address` varchar(255) DEFAULT NULL COMMENT '現場場所',
  `pay_deadline` varchar(255) DEFAULT NULL COMMENT '付款期限',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目管理表';

-- ----------------------------
-- Records of t_project
-- ----------------------------

-- ----------------------------
-- Table structure for t_sales
-- ----------------------------
DROP TABLE IF EXISTS `t_sales`;
CREATE TABLE `t_sales` (
  `sales_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '营业id',
  `employee_site_id` int(11) DEFAULT NULL COMMENT '员工现场记录id'',',
  `expect_entery_date1` varchar(255) DEFAULT NULL COMMENT '希望入场日1',
  `expect_entery_date2` varchar(255) DEFAULT NULL COMMENT '希望入场日2',
  ` first_project` varchar(50) DEFAULT NULL COMMENT '优先项目1',
  `second_project` varchar(50) DEFAULT NULL COMMENT '优先项目2',
  `third_project` varchar(50) DEFAULT NULL COMMENT '优先项目3',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`sales_id`),
  KEY `fk_employee_site_sales_employeesiteid` (`employee_site_id`),
  CONSTRAINT `fk_employee_site_sales_employeesiteid` FOREIGN KEY (`employee_site_id`) REFERENCES `t_employee_site` (`employee_site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='营业-员工信息表';

-- ----------------------------
-- Records of t_sales
-- ----------------------------
INSERT INTO `t_sales` VALUES ('1', '1', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_sales` VALUES ('2', '2', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_sales` VALUES ('3', '3', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_sales` VALUES ('4', null, null, null, null, null, null, null, '2019-05-29 20:08:02', null, null);

-- ----------------------------
-- Table structure for t_sales_record
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_record`;
CREATE TABLE `t_sales_record` (
  `sales_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '营业记录id',
  `sales_id` int(11) DEFAULT NULL COMMENT '营业id',
  `sales_handler` int(11) DEFAULT NULL COMMENT '营业担当',
  `interview_date` date DEFAULT NULL COMMENT '面试日期',
  `interview_time` time DEFAULT NULL COMMENT '面试时间',
  `priority` tinyint(4) DEFAULT '0' COMMENT '优先度(1:低 2:中 3:高)',
  `interview_address` varchar(255) DEFAULT NULL COMMENT '面试地点',
  `interview_frequency` int(11) DEFAULT NULL COMMENT '面试次数（对应字典表）',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `enter_date` date DEFAULT NULL COMMENT '入场日',
  `notice1` varchar(255) DEFAULT NULL COMMENT '注意事项1',
  `notice2` varchar(255) DEFAULT NULL COMMENT '注意事项2',
  `is_done` bit(1) DEFAULT b'0' COMMENT '是否已经参加面试（0:未参加 1:已参加）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `delete_flag` bit(1) DEFAULT b'0' COMMENT '是否已删除(0:否 1:是)',
  PRIMARY KEY (`sales_record_id`),
  KEY `fk_sales_sales_record_salesid` (`sales_id`),
  KEY `fk_project_sales_record_projectid` (`project_id`),
  CONSTRAINT `fk_project_sales_record_projectid` FOREIGN KEY (`project_id`) REFERENCES `t_project` (`project_id`),
  CONSTRAINT `fk_sales_sales_record_salesid` FOREIGN KEY (`sales_id`) REFERENCES `t_sales` (`sales_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营业记录表';

-- ----------------------------
-- Records of t_sales_record
-- ----------------------------
