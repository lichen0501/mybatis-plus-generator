package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import java.util.List;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(description = "${table.comment!}接口")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @GetMapping("/")
    @ApiOperation(value = "查询${table.comment!}列表")
    public List<${entity}> getList() {
        return null;
    }

    @PostMapping("/")
    @ApiOperation(value = "新增${table.comment!}")
    public String addOne(@RequestBody ${entity} ${entity?uncap_first}) {
        return null;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "通过id查询${table.comment!}")
    public CompanyAssurance getOne(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新${table.comment!}")
    public String update(@PathVariable Long id, @RequestBody ${entity} ${entity?uncap_first}) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过id删除${table.comment!}")
    public String delete(@PathVariable Long id) {
        return null;
    }

}
</#if>
