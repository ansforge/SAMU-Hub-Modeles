import re
from typing import List, Dict, Any

def delete_paths(data: Dict[str, Any], paths: List[str]) -> None:
    """
    Safely deletes keys in a dictionary based on dot-separated paths.
    
    Args:
        data: Dictionary to modify
        paths: List of dot-separated paths (e.g., "a.b.c")
    """
    def delete_recursively(d: Dict[str, Any], keys: List[str]) -> None:
        if not keys or not isinstance(d, dict):
            return
            
        key = keys[0]
        if len(keys) == 1:
            # Delete target key if it exists
            d.pop(key, None)
        else:
            # Recurse if intermediate key exists
            if key in d:
                delete_recursively(d[key], keys[1:])
                # Clean up empty dictionaries
                if isinstance(d[key], dict) and not d[key]:
                    d.pop(key)

    for path in paths:
        delete_recursively(data, path.split("."))

def add_space_before_uppercase(text):
    # Add a space before each uppercase letter
    return re.sub(r'([A-Z])', r' \1', text).strip()

def format_object(obj: Any, indent: int = 0) -> str:
    """
    Recursively formats an object into a readable string.
    
    Args:
        obj: Object to format
        indent: Current indentation level (for recursion)
        
    Returns:
        Formatted string representation with proper indentation and structure
    """
    indent_str = "  " * indent
    
    if hasattr(obj, '__dict__'):  # Object with attributes
        attributes = vars(obj)
        if not attributes:
            return f"{indent_str}No attributes to display."
            
        formatted_lines = []
        
        # Add class name at root level
        if indent == 0:
            formatted_lines.append(f"{indent_str}{add_space_before_uppercase(obj.__class__.__name__)}:")
            
        for field, value in attributes.items():
            if value is None:  # Skip None values
                continue
                
            if hasattr(value, '__dict__'):  # Nested object
                formatted_lines.append(f"{indent_str}- {field.replace('_', ' ').title()}:")
                formatted_lines.append(format_object(value, indent=indent + 1))
            else:  # Primitive value
                formatted_lines.append(f"{indent_str}- {field.replace('_', ' ').title()}: {value}")
                
        return "\n".join(formatted_lines)
        
    # Handle collections
    if isinstance(obj, list):
        return "\n".join(f"{indent_str}- {format_object(item, indent + 1)}" for item in obj)
    elif isinstance(obj, dict):
        formatted_lines = []
        for key, value in obj.items():
            formatted_lines.append(f"{indent_str}- {key.replace('_', ' ').title()}:")
            formatted_lines.append(format_object(value, indent + 1))
        return "\n".join(formatted_lines)
        
    # Base case for primitives
    return f"{indent_str}{obj}" 