package com.issane.waifubattletheater.character

import android.view.View
import com.issane.waifubattletheater.game.GameDef
import com.issane.waifubattletheater.game.Properties


/**
 * 角色实体接口。  存储角色相关信息
 *
 * @author issane
 * @version 1.0
 * @since 2020/8/7
 **/
interface Character {
    /**
     * 角色唯一标识  --- 相同角色也是不同的
     */
    fun getCharacterId(): Int

    /**
     * 获取这个角色的 立绘样式
     */
    fun getView(): View?

    /**
     * 获取这个角色 来源的游戏
     */
    fun getGame(): GameDef

    /**
     * 获取这个角色 的属性参数
     */
    fun getProperties(): Properties?

    fun getFullName(): String?

    fun getDisplayName(): String

    /**
     * 获取这个角色 的头像
     */
    fun getAvatar(): View?

    /**
     * 获取这个角色 的口头禅， 可能会为空
     */
    fun getPetPhrase(): List<String>?
}