# Summary
Abstractium is a moderately simple mod that provides tools to abstract interactive code between a mod and 
given dependency.

# What does this do?
Abstractium's branch looks a little like this:
- Abstractium = "Api" + "Minecraft Abstraction";
- Api = "Events" + "Abstraction Tools";

**Events** function similarly to basically every other event system out there with the small
difference that it also has concurrent capabilities and string-based identification systems.
It is used to hold the main "function" of a mixin that potentially might not work in another
update.

The **Abstraction Tools** provide an easy way to essentially implement an interface of pre-made calls a.k.a
"Abstraction Mappings". The different versions of abstraction mappings are registered through an entrypoint.
The AbstractionHandler.java class handles all the versioning automatically. The abstraction mappings also
allow for "sub-abstraction", where a subset of specific calls can reside. Here is an example hierarchy:
- AbstractClientCalls{
  - AbstractRenderCalls{
    - AbstractWorldRenderCalls{
      - AbstractBlockRenderCalls{},
      - AbstractEntityRenderCalls{}
    - }, 
    - AbstractGuiRenderCalls{}
  - }, 
  - AbstractSoundCalls{
    - AbstractEntitySoundCalls{},
    - AbstractBlockSoundCalls{}
  - }
- }

The **Minecraft Abstraction** puts all this together to provide an inbuilt abstraction layer for other mods
to use. Please keep in mind that this is far from finished. There is a bare minimum to get my mods ported to
it but that's about it. If you feel like contributing, just keep in mind that I'll only accept abstractions
that world for all inbuilt versions this api supports.

# How do I use this?
Well if you do want to use my inbuilt minecraft abstraction, it's actually really easy! Just add my mod
to your dependency list (There will be documentation for that shortly) and access 
`AbstractiumClient#CLIENT_ABSTRACTION_HANDLER` or `AbstractiumCommon#COMMON_ABSTRACTION_HANDLER`.
If you want to make your own abstraction handling, well that's quite a bit more complicated but you will
need to follow how it's done in `net.feltmc.abstractium.library`.
There will be a wiki some time in the future.

# Development Roadmap
For now this has rather limited goals. Support **fabric 1.18.2** to the **latest version**. In the future
there are **possibilities not plans** for the following:
- Code Wrapper: This would allow mods from different versions running on newer ones without modifications.
- Legacy Support: Supporting versions below 1.18.2.
- Forge Abstraction: Abstracting and wrapping forge code (contingent upon another PatchworkMC)

# Why was this made?
I made this api because of how much mojang loves to refactor their own code. I know mod devs alike can agree
with me that mojang's refactors make modding so tedious and demotivating. It forces us devs to focus less on
improving the mod and more on rewriting code to get it working on the latest versions. Then, if someone wants
to maintain multiple versions, multiple branches have to be updated with patches/improvements which is a 
logistical nightmare. For the users it causes many, many mods to be split amongst different versions. This
stops people from playing all their favourite mods in one modpack, on the latest versions. This frustration
has been productively redirected to an ambitious api to finally nuke these irritating nuisances out of existence.

# Links
- Modrinth: https://modrinth.com/mod/abstractium
- Curseforge: https://www.curseforge.com/minecraft/mc-mods/abstractium
- Discord: https://discord.gg/fMSnenNSXM
