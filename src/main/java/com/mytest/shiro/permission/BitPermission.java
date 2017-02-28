package com.mytest.shiro.permission;


import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.authz.Permission;

/**
 * Created by miyan(弥彦) on 2017/2/28 11:13.
 */
public class BitPermission implements Permission {
    //
    private String resourceIdentify;
    private int permissionBit;
    private String instanceId;

    /**
     * 权限字符串格式：+资源字符串+权限位+实例ID；以+开头中间通过+分割
     * ；权限：0 表示所有权限；1 新增（二进制：0001）、2 修改（二进制：0010）、4 删除（二进制：0100）、8 查看（二进制：1000）；如 +user+10 表示对资源user拥有修改/查看权限。
     * @param permissionString
     */
    public BitPermission(String permissionString ) {
        if (permissionString == null) throw new RuntimeException("权限字符串 can not null");
        String[] array = permissionString.split("\\+");
        if (array.length > 1){
            resourceIdentify = array[1];
        }
        if (StringUtils.isEmpty(resourceIdentify)){
            resourceIdentify = "*";
        }
        if (array.length > 2){
            permissionBit = Integer.parseInt(array[2]);
        }
        if (array.length > 3){
            instanceId = array[3];
        }
        if (StringUtils.isEmpty(instanceId)){
            instanceId = "*";
        }

    }

    @Override
    public boolean implies(Permission permission) {
        if (!(permission instanceof BitPermission)) return false;
        BitPermission bitPermission = (BitPermission) permission;
        if (!("*".equals(bitPermission.resourceIdentify) || this.resourceIdentify.equals(bitPermission.resourceIdentify))){
            return false;
        }
        if (!(this.permissionBit== 0 || (this.permissionBit & bitPermission.permissionBit) != 0)){
            return false;
        }
        if (!(this.instanceId.equals(bitPermission.instanceId) || "*".equals(bitPermission.instanceId))){
            return false;
        }

        return true;
    }
}
