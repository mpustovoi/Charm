# Charm for Minecraft 1.21

Dev tasks:
- advancement trigger methods and lang keys should match name of advancement
- rename API interfaces, clean up unneeded
- move any heavy interaction logic out of item/block and into handlers
- handle custom_wood and variant_wood mess in variants
- ignore unregistered data fixer errors - add feature to Silence?
- all static config props to be private with accessors
- Untranlated item tags warning - add tag.item.<namespace>.<path> with slashes in tag path as periods