package com.example.kevin.managerspendingandincome.javabean;

/**
 * Created by kevin on 2018/3/31.
 * https://github.com/yinkaiwen
 * <p>
 * 资产的实体类：用来封装数据和相应的名称
 */
public class AssetsEntity {
    public float data;
    public String name;

    public AssetsEntity(float data, String name) {
        this.data = data;
        this.name = name;
    }

    public AssetsEntity() {
    }

    @Override
    public int hashCode() {
        int p = 37;
        int r = 17;
        int rs = (int) (p + r * data);
        rs += (p + r * name.hashCode());
        return rs;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if(obj instanceof AssetsEntity){
            AssetsEntity other = (AssetsEntity) obj;
            if(other.name.equals(name)){
                return true;
            }
        }


        return false;
    }
}
